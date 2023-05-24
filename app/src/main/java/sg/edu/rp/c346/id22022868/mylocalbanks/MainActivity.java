package sg.edu.rp.c346.id22022868.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    String bankSelect = "";
    CheckBox checkFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.dbs);
        tvOCBC= findViewById(R.id.ocbc);
        tvUOB = findViewById(R.id.uob);

        //textviews to include context menu with
        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);


    }

    @Override
    //Context menu (long press) for website or calling items to be shown
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_bank, menu);

        if (v == tvDBS) {
            bankSelect = "DBS";
        }
        else if (v == tvOCBC) {
            bankSelect = "OCBC";
        }
        else if (v == tvUOB) {
            bankSelect = "UOB";
        }

    }

    @Override
    //action to take on selection of item
    public boolean onContextItemSelected(MenuItem item) {

        //retrieve id of items
        int id = item.getItemId();

        //initialising the checkbox menu item
        checkFav = findViewById(R.id.toggleFavourite);


        //bank sites and numbers
        if (bankSelect.equals("DBS")) {
            if (id == R.id.website) {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentWebsite);
                return true;
            }
            else if (id == R.id.callBank) {
                String dbsNo = "18001111111";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+Long.parseLong(dbsNo)));
                startActivity(intentCall);
                return true;
            }
            if (id == R.id.toggleFavourite) {
                tvDBS.setTextColor(Color.parseColor("#EB4034"));
                item.setChecked(true);
                return true;
            }
        }
        else if (bankSelect.equals("OCBC")) {
            if (id == R.id.website) {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentWebsite);
                return true;
            } else if (id == R.id.callBank) {
                String ocbcNo = "18003633333";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+Long.parseLong(ocbcNo)));
                startActivity(intentCall);
                return true;
            }
            if (id == R.id.toggleFavourite) {
                tvOCBC.setTextColor(Color.parseColor("#EB4034"));
                item.setChecked(true);
                return true;
            }
        }
        else if (bankSelect.equals("UOB")) {
            if (id == R.id.website) {
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentWebsite);
                return true;
            } else if (id == R.id.callBank) {
                String uobNo = "18002222121";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+Long.parseLong(uobNo)));
                startActivity(intentCall);
                return true;
            }
            if (id == R.id.toggleFavourite) {
                tvUOB.setTextColor(Color.parseColor("#EB4034"));
                item.setChecked(true);
                return true;
            }
        }

        return super.onContextItemSelected(item);
    }

    //For language options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_language, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.englishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        }
        else if (id == R.id.chineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        }
/*        else if (id == R.id.japaneseSelection){
            tvTranslatedText.setText("Error translation");
        }*/
        else {
            Toast.makeText(MainActivity.this, "Error translation", Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }

}
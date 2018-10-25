package hsport.com.example.king.storyadapter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

  public static   int redColor ;
    public static  int grayColor ;
    public static  int whiteColor ;
    public static int textSize=14;
    private int fontSize;

    Button save;
    RadioButton white, gray, red;
   public static int backgroundColor =whiteColor;

    /*@Override
    protected void onStart() {
        super.onStart();


    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Spinner spinner = findViewById(R.id.spinner_id);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.
                createFromResource(this, R.array.fontSize, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        white = findViewById(R.id.white_id);
        gray = findViewById(R.id.gray_id);
        red = findViewById(R.id.red_id);
        save = findViewById(R.id.save_id);
        redColor = getResources().getColor(R.color.category_red);
        grayColor = getResources().getColor(R.color.category_gray);
        whiteColor = getResources().getColor(R.color.category_white);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        fontSize= Integer.parseInt(parent.getItemAtPosition(position).toString());
       /* DetailsActivity.PriceView.setTextSize(textSize);
        DetailsActivity.desView.setTextSize(textSize);*/
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void saves(View view) {
        if (red.isChecked()) {
            backgroundColor=redColor;
        } else if (gray.isChecked()) {
            backgroundColor=grayColor;
        } else if (white.isChecked()) {
            backgroundColor=whiteColor;
        }
      textSize=fontSize;
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences=getSharedPreferences("settings",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("color",backgroundColor);
        editor.putInt("textSize",textSize);
        editor.commit();
    }

}

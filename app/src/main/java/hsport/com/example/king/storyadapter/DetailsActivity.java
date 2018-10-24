package hsport.com.example.king.storyadapter;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;

public class DetailsActivity extends AppCompatActivity {
    public static   TextView PriceView,desView;
    public static View containerView;
    private int position;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        String[] description = {"WE DO STANDARD, TOO. IT JUST HAPPENS TO BE HIGHER.\n" +
                "For us quality is not only a promise but also a principle. A pre-owned vehicle with the BMW Premium Selection certificate " +
                "is at most five years old and has a maximum mileage of 120,000 km. It has also undergone a rigorous inspection " +
                "in our 360° vehicle check. Only vehicles that meet all the precisely defined product standards are certified." +
                " Premium Selection vehicles are exclusively available from BMW Premium Selection partners," +
                " so that we can always guarantee you maximum quality. Come and see for yourself!",

                "BENEFITS FROM EVERY ANGLE.\n" +
                        "Every BMW Premium Selection pre-owned vehicle has undergone a 360° check by our experts to ensure that it meets the highest" +
                        " standards. However, in addition to certified quality, a BMW Premium Selection pre-owned vehicle also offers you many " +
                        "additional benefits. Marvel at the comprehensive guarantee and mobility services, attractive financing " +
                        "additional benefits. Marvel at the comprehensive guarantee and mobility services, attractive financing " +
                        "additional benefits. Marvel at the comprehensive guarantee and mobility services, attractive financing " +
                        "additional benefits. Marvel at the comprehensive guarantee and mobility services, attractive financing " +
                        "models and above all: sheer driving pleasure.",

                "OFFERS WITH PERSONALITY.\n" +
                        "With the versatile offers from BMW Premium Selection, we quickly find you a car that matches your very personal requirements." +
                        " Profit from our unique choice. All you have to do is contact your BMW Premium Selection partner directly or explore the" +
                        "additional benefits. Marvel at the comprehensive guarantee and mobility services, attractive financing " +
                        "additional benefits. Marvel at the comprehensive guarantee and mobility services, attractive financing " +
                        "additional benefits. Marvel at the comprehensive guarantee and mobility services, attractive financing " +
                        "additional benefits. Marvel at the comprehensive guarantee and mobility services, attractive financing " +
                        "additional benefits. Marvel at the comprehensive guarantee and mobility services, attractive financing " +
                        "additional benefits. Marvel at the comprehensive guarantee and mobility services, attractive financing " +
                        "additional benefits. Marvel at the comprehensive guarantee and mobility services, attractive financing " +
                        " new models at favourable conditions that regularly appear here."};

        String bmw = description[0];
        String audi = description[1];
        String peugeot = description[2];

        containerView =findViewById(R.id.detailsLayout);


        int position = getIntent().getIntExtra("index", 1001);

        PriceView = findViewById(R.id.textView4);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String prices = formatter.format(MainActivity.stories.get(position).getPrice());
        PriceView.setText(prices);


        desView = findViewById(R.id.textView3);
        switch (MainActivity.stories.get(position).getTitle()) {
            case "BMW":
                desView.setText(bmw);
                break;

            case "Audi":
                desView.setText(audi);
                break;

            case "Peugeot":
                desView.setText(peugeot);
                break;
            default:
                desView.setText("hello baby");
        }


        Bitmap bitmap = getBitmap(MainActivity.stories.get(position).getSubTitle());
        ImageView carPhoto = findViewById(R.id.imageView2);
        carPhoto.setImageBitmap(bitmap);
    }

    private Bitmap getBitmap(String subTitle) {
        AssetManager assetManager = getAssets();
        InputStream stream = null;

        try {
            stream = assetManager.open(subTitle + ".jpg");
            return BitmapFactory.decodeStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings_id:
                Intent openSettings =new Intent(DetailsActivity.this,SettingsActivity.class);
                startActivity(openSettings);

                break;
            case R.id.exit_id:
                finish();
                break;
        }
        return true;
    }
}
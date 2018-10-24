package hsport.com.example.king.storyadapter;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    public static ArrayList<Story> stories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stories = new ArrayList<Story>();
        stories.add(new Story("BMW", "b_model_2015", 1000000, R.color.category_bmw));
        stories.add(new Story("BMW", "b_model_2016", 2000000, R.color.category_bmw));
        stories.add(new Story("BMW", "b_model_2017", 3000000, R.color.category_bmw));
        stories.add(new Story("BMW", "b_model_2018", 4000000, R.color.category_bmw));
        stories.add(new Story("Audi", "a_model_2015", 3000000, R.color.category_audi));
        stories.add(new Story("Audi", "a_model_2016", 2000000, R.color.category_audi));
        stories.add(new Story("Audi", "a_model_2017", 1000000, R.color.category_audi));
        stories.add(new Story("Peugeot", "p_model_2015", 5043000, R.color.category_peugoet));
        stories.add(new Story("Peugeot", "p_model_2016", 1000000, R.color.category_peugoet));
        stories.add(new Story("Peugeot", "p_model_2017", 5020000, R.color.category_peugoet));
        stories.add(new Story("Peugeot", "p_model_2018", 3003000, R.color.category_peugoet));


        ListView listView = findViewById(R.id.listView);

        StoryAdapter adapter = new StoryAdapter(MainActivity.this, stories);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


               Intent openDetails=new Intent(MainActivity.this,DetailsActivity.class);
               openDetails.putExtra("index",position);

               startActivity(openDetails);


            }
        });
    }


}

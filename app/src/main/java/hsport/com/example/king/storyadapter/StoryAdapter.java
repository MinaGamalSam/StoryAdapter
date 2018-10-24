package hsport.com.example.king.storyadapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by King on 22/10/2018.
 */

public class StoryAdapter extends ArrayAdapter<Story> {
    public StoryAdapter( Context context, ArrayList<Story> stories) {
        super(context, 0, stories);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_items, parent, false);
        }
        Story currentStory = getItem(position);

        TextView titleView = listView.findViewById(R.id.main_title);
        titleView.setText(currentStory.getTitle());

        TextView subTitleView = listView.findViewById(R.id.sub_title);
        subTitleView.setText(currentStory.getSubTitle());

        TextView price = listView.findViewById(R.id.price);
        NumberFormat formatter =NumberFormat.getCurrencyInstance();
        String prices =formatter.format(currentStory.getPrice());
        price.setText(prices);

        View containerView =listView.findViewById(R.id.kotlins);
        int color = ContextCompat.getColor(getContext(),currentStory.getViewColors());
        containerView.setBackgroundColor(color);

        ImageView image =listView.findViewById(R.id.car_photo);
        image.setImageBitmap(getBitmap(currentStory.getSubTitle()));

        ImageView logoImage = listView.findViewById(R.id.logo_view);
        logoImage.setImageBitmap(getAssetsLogo(currentStory.getTitle()));


        return listView;
    }
    private   Bitmap getBitmap(String subTitle){
        AssetManager assetManager = getContext().getAssets();
        InputStream stream = null;

        try {
            stream=assetManager.open(subTitle+".jpg");
            return BitmapFactory.decodeStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }
    private Bitmap getAssetsLogo(String title){
        AssetManager assetManager =getContext().getAssets();
        InputStream stream=null;

        try {
            stream =assetManager.open(title+".png");
            return BitmapFactory.decodeStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

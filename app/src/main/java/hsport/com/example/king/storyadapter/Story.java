package hsport.com.example.king.storyadapter;

/**
 * Created by King on 22/10/2018.
 */

public class Story {
    private String title, subTitle;
    private int price,viewColors;

    public Story(String title, String subTitle, int price,int viewColors) {
        this.title = title;
        this.subTitle = subTitle;
        this.price = price;
        this.viewColors = viewColors;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public int getPrice() {
        return price;
    }

    public int getViewColors() {
        return viewColors;
    }
}

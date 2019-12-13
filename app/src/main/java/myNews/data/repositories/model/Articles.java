package myNews.data.repositories.model;

/**
 * Created by Remy Pouzet on 21/11/2019.
 */
public class Articles
{
    private int mDrawableImage;
    private String mUrlImage;
    private String mCategory;
    private String mUnderCategory;
    private String mTitle;
    private String mDate;

    public Articles(int drawableImage, String urlImage, String category, String underCategory, String title, String date)
    {
        mDrawableImage = drawableImage;
        mUrlImage = urlImage;
        mCategory = category;
        mUnderCategory = underCategory;
        mTitle = title;
        mDate = date;

    }

    public int getDrawableImage()
    {
        return mDrawableImage;
    }


    public String getDate()
    {
        return mDate;
    }


    public String getUrlImage()
    {
        return mUrlImage;
    }


    public String getCategory()
    {
        return mCategory;
    }


    public String getUnderCategory()
    {
        return mUnderCategory;
    }


    public String getTitle()
    {
        return mTitle;
    }



}

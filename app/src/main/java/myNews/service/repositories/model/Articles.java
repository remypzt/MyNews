package myNews.service.repositories.model;

/**
 * Created by Remy Pouzet on 21/11/2019.
 */
public class Articles
{
    private String mUrlImage;
    private String mCategory;
    private String mUnderCategory;
    private String mTitle;
    private long mDate;

    public Articles(String urlImage, String category, String underCategory, String title, long date)
    {
        mUrlImage = urlImage;
        mCategory = category;
        mUnderCategory = underCategory;
        mTitle = title;
        mDate = date;
    }

    public String getUrlImage()
    {
        return mUrlImage;
    }

    public void setUrlImage(String urlImage)
    {
        mUrlImage = urlImage;
    }

    public String getCategory()
    {
        return mCategory;
    }

    public void setCategory(String category)
    {
        mCategory = category;
    }

    public String getUnderCategory()
    {
        return mUnderCategory;
    }

    public void setUnderCategory(String underCategory)
    {
        mUnderCategory = underCategory;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public void setTitle(String title)
    {
        mTitle = title;
    }

    public long getDate()
    {
        return mDate;
    }

    public void setDate(long date)
    {
        mDate = date;
    }
}

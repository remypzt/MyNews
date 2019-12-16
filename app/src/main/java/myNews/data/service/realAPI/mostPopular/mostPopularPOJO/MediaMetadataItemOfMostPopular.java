package myNews.data.service.realAPI.mostPopular.mostPopularPOJO;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class MediaMetadataItemOfMostPopular
{

    @SerializedName("format")
    private String format;

    @SerializedName("width")
    private int width;

    @SerializedName("url")
    private String url;

    @SerializedName("height")
    private int height;

    public String getFormat()
    {
        return format;
    }

    public void setFormat(String format)
    {
        this.format = format;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    @Override
    public String toString()
    {
        return
                "MediaMetadataItemOfMostPopular{" +
                        "format = '" + format + '\'' +
                        ",width = '" + width + '\'' +
                        ",url = '" + url + '\'' +
                        ",height = '" + height + '\'' +
                        "}";
    }
}
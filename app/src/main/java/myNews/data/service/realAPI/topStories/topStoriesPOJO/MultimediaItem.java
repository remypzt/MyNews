package myNews.data.service.realAPI.topStories.topStoriesPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class MultimediaItem
{

    @SerializedName("copyright")
    private String copyright;

    @SerializedName("subtype")
    private String subtype;

    @SerializedName("format")
    private String format;

    @SerializedName("width")
    private int width;

    @SerializedName("caption")
    private String caption;

    @SerializedName("type")
    private String type;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("height")
    private int height;

    public String getCopyright()
    {
        return copyright;
    }

    public void setCopyright(String copyright)
    {
        this.copyright = copyright;
    }

    public String getSubtype()
    {
        return subtype;
    }

    public void setSubtype(String subtype)
    {
        this.subtype = subtype;
    }

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

    public String getCaption()
    {
        return caption;
    }

    public void setCaption(String caption)
    {
        this.caption = caption;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
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
                "MultimediaItem{" +
                        "copyright = '" + copyright + '\'' +
                        ",subtype = '" + subtype + '\'' +
                        ",format = '" + format + '\'' +
                        ",width = '" + width + '\'' +
                        ",caption = '" + caption + '\'' +
                        ",type = '" + type + '\'' +
                        ",url = '" + url + '\'' +
                        ",height = '" + height + '\'' +
                        "}";
    }
}
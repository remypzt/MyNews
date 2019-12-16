package myNews.data.service.realAPI.articleSearch.articleSearchPOJO;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class MetaOfArticleSearch
{

    @SerializedName("hits")
    private int hits;

    @SerializedName("offset")
    private int offset;

    @SerializedName("time")
    private int time;

    public int getHits()
    {
        return hits;
    }

    public void setHits(int hits)
    {
        this.hits = hits;
    }

    public int getOffset()
    {
        return offset;
    }

    public void setOffset(int offset)
    {
        this.offset = offset;
    }

    public int getTime()
    {
        return time;
    }

    public void setTime(int time)
    {
        this.time = time;
    }

    @Override
    public String toString()
    {
        return
                "MetaOfArticleSearch{" +
                        "hits = '" + hits + '\'' +
                        ",offset = '" + offset + '\'' +
                        ",time = '" + time + '\'' +
                        "}";
    }
}
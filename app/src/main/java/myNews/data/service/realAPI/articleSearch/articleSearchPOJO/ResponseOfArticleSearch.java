package myNews.data.service.realAPI.articleSearch.articleSearchPOJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ResponseOfArticleSearch
{

    @SerializedName("copyright")
    private String copyright;

    @SerializedName("mResponseOfArticleSearch")
    private ResponseOfArticleSearch mResponseOfArticleSearch;

    @SerializedName("status")
    private String status;

    @SerializedName("docs")
    private List<DocsItemOfArticleSearch> docs;

    @SerializedName("mMetaOfArticleSearch")
    private MetaOfArticleSearch mMetaOfArticleSearch;

    public String getCopyright()
    {
        return copyright;
    }

    public void setCopyright(String copyright)
    {
        this.copyright = copyright;
    }

    public ResponseOfArticleSearch getResponseOfArticleSearch()
    {
        return mResponseOfArticleSearch;
    }

    public void setResponseOfArticleSearch(ResponseOfArticleSearch responseOfArticleSearch)
    {
        this.mResponseOfArticleSearch = responseOfArticleSearch;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public List<DocsItemOfArticleSearch> getDocs()
    {
        return docs;
    }

    public void setDocs(List<DocsItemOfArticleSearch> docs)
    {
        this.docs = docs;
    }

    public MetaOfArticleSearch getMetaOfArticleSearch()
    {
        return mMetaOfArticleSearch;
    }

    public void setMetaOfArticleSearch(MetaOfArticleSearch metaOfArticleSearch)
    {
        this.mMetaOfArticleSearch = metaOfArticleSearch;
    }

    @Override
    public String toString()
    {
        return
                "ResponseOfArticleSearch{" +
                        "copyright = '" + copyright + '\'' +
                        ",mResponseOfArticleSearch = '" + mResponseOfArticleSearch + '\'' +
                        ",status = '" + status + '\'' +
                        ",docs = '" + docs + '\'' +
                        ",mMetaOfArticleSearch = '" + mMetaOfArticleSearch + '\'' +
                        "}";
    }
}
package myNews.data.service.realAPI.topStories.topStoriesPOJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ResponseTopStories
{

    @SerializedName("copyright")
    private String copyright;

    @SerializedName("last_updated")
    private String lastUpdated;

    @SerializedName("section")
    private String section;

    @SerializedName("results")
    private List<ResultsItem> results;

    @SerializedName("num_results")
    private int numResults;

    @SerializedName("status")
    private String status;

    public String getCopyright()
    {
        return copyright;
    }

    public void setCopyright(String copyright)
    {
        this.copyright = copyright;
    }

    public String getLastUpdated()
    {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

    public String getSection()
    {
        return section;
    }

    public void setSection(String section)
    {
        this.section = section;
    }

    public List<ResultsItem> getResults()
    {
        return results;
    }

    public void setResults(List<ResultsItem> results)
    {
        this.results = results;
    }

    public int getNumResults()
    {
        return numResults;
    }

    public void setNumResults(int numResults)
    {
        this.numResults = numResults;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return
                "ResponseTopStories{" +
                        "copyright = '" + copyright + '\'' +
                        ",last_updated = '" + lastUpdated + '\'' +
                        ",section = '" + section + '\'' +
                        ",results = '" + results + '\'' +
                        ",num_results = '" + numResults + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
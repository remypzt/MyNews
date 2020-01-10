package myNews.data.service.realAPI.mostPopular.mostPopularPOJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ResponseOfMostPopular {

    @SerializedName("copyright")
    private String copyright;

    @SerializedName("results")
    private List<ResultsItemOfMostPopular> results;

    @SerializedName("num_results")
    private int numResults;

    @SerializedName("status")
    private String status;

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public List<ResultsItemOfMostPopular> getResults() {
        return results;
    }

    public void setResults(List<ResultsItemOfMostPopular> results) {
        this.results = results;
    }

    public int getNumResults() {
        return numResults;
    }

    public void setNumResults(int numResults) {
        this.numResults = numResults;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResponseOfMostPopular{" + "copyright = '" + copyright + '\'' + ",results = '" + results + '\'' + ",num_results = '" + numResults + '\'' + ",status = '" + status + '\'' + "}";
    }
}
package myNews.data.service.realAPI.articleSearch.articleSearchPOJO;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class KeywordsItemOfArticleSearch {

    @SerializedName("major")
    private String major;

    @SerializedName("name")
    private String name;

    @SerializedName("rank")
    private int rank;

    @SerializedName("value")
    private String value;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "KeywordsItemOfArticleSearch{" + "major = '" + major + '\'' + ",name = '" + name + '\'' + ",rank = '" + rank + '\'' + ",value = '" + value + '\'' + "}";
    }
}
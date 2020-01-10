package myNews.data.service.realAPI.topStories.topStoriesPOJO;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ResultsItemOfTopStories {


    @SerializedName("subsection")
    private String subsection;

    @SerializedName("item_type")
    private String itemType;


    @SerializedName("section")
    private String section;

    @SerializedName("abstract")
    private String jsonMemberAbstract;

    @SerializedName("title")
    private String title;


    @SerializedName("url")
    private String url;

    @SerializedName("short_url")
    private String shortUrl;


    @SerializedName("multimedia")
    private List<MultimediaItemOfTopStories> multimedia;


    @SerializedName("updated_date")
    private String updatedDate;

    @SerializedName("created_date")
    private String createdDate;

    @SerializedName("byline")
    private String byline;

    @SerializedName("published_date")
    private String publishedDate;

    @SerializedName("kicker")
    private String kicker;


    public String getSubsection() {
        return subsection;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }


    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getJsonMemberAbstract() {
        return jsonMemberAbstract;
    }

    public void setJsonMemberAbstract(String jsonMemberAbstract) {
        this.jsonMemberAbstract = jsonMemberAbstract;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }


    public List<MultimediaItemOfTopStories> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(List<MultimediaItemOfTopStories> multimedia) {
        this.multimedia = multimedia;
    }


    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getKicker() {
        return kicker;
    }

    public void setKicker(String kicker) {
        this.kicker = kicker;
    }

    @Override
    public String toString() {
        return "ResultsItemOfTopStories{" +

                ",subsection = '" + subsection + '\'' + ",item_type = '" + itemType + '\'' +

                ",section = '" + section + '\'' + ",abstract = '" + jsonMemberAbstract + '\'' + ",title = '" + title + '\'' + ",url = '" + url + '\'' + ",short_url = '" + shortUrl + '\'' + ",multimedia = '" + multimedia + '\'' + ",updated_date = '" + updatedDate + '\'' + ",created_date = '" + createdDate + '\'' + ",byline = '" + byline + '\'' + ",published_date = '" + publishedDate + '\'' + ",kicker = '" + kicker + '\'' + "}";
    }
}
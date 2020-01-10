package myNews.data.service.realAPI.mostPopular.mostPopularPOJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ResultsItemOfMostPopular {


    @SerializedName("column")
    private Object column;

    @SerializedName("section")
    private String section;

    @SerializedName("abstract")
    private String jsonMemberAbstract;

    @SerializedName("source")
    private String source;

    @SerializedName("asset_id")
    private long assetId;

    @SerializedName("media")
    private List<MediaItemOfMostPopular> media;

    @SerializedName("type")
    private String type;

    @SerializedName("title")
    private String title;


    @SerializedName("uri")
    private String uri;

    @SerializedName("url")
    private String url;

    @SerializedName("adx_keywords")
    private String adxKeywords;


    @SerializedName("id")
    private long id;

    @SerializedName("byline")
    private String byline;

    @SerializedName("published_date")
    private String publishedDate;

    @SerializedName("views")
    private int views;


    public Object getColumn() {
        return column;
    }

    public void setColumn(Object column) {
        this.column = column;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public long getAssetId() {
        return assetId;
    }

    public void setAssetId(long assetId) {
        this.assetId = assetId;
    }

    public List<MediaItemOfMostPopular> getMedia() {
        return media;
    }

    public void setMedia(List<MediaItemOfMostPopular> media) {
        this.media = media;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdxKeywords() {
        return adxKeywords;
    }

    public void setAdxKeywords(String adxKeywords) {
        this.adxKeywords = adxKeywords;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "ResultsItemOfTopStories{" +

                ",column = '" + column + '\'' + ",section = '" + section + '\'' + ",abstract = '" + jsonMemberAbstract + '\'' + ",source = '" + source + '\'' + ",asset_id = '" + assetId + '\'' + ",media = '" + media + '\'' + ",type = '" + type + '\'' + ",title = '" + title + '\'' +

                ",uri = '" + uri + '\'' + ",url = '" + url + '\'' + ",adx_keywords = '" + adxKeywords + '\'' +

                ",id = '" + id + '\'' + ",byline = '" + byline + '\'' + ",published_date = '" + publishedDate + '\'' + ",views = '" + views + '\'' + "}";
    }


}
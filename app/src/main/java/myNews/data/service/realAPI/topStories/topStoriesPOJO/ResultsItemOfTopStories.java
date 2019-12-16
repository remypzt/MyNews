package myNews.data.service.realAPI.topStories.topStoriesPOJO;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ResultsItemOfTopStories
{

    @SerializedName("per_facet")
    private List<String> perFacet;

    @SerializedName("subsection")
    private String subsection;

    @SerializedName("item_type")
    private String itemType;

    @SerializedName("org_facet")
    private List<String> orgFacet;

    @SerializedName("section")
    private String section;

    @SerializedName("abstract")
    private String jsonMemberAbstract;

    @SerializedName("title")
    private String title;

    @SerializedName("des_facet")
    private List<String> desFacet;

    @SerializedName("url")
    private String url;

    @SerializedName("short_url")
    private String shortUrl;

    @SerializedName("material_type_facet")
    private String materialTypeFacet;

    @SerializedName("multimedia")
    private List<MultimediaItemOfTopStories> multimedia;

    @SerializedName("geo_facet")
    private List<Object> geoFacet;

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

    public List<String> getPerFacet()
    {
        return perFacet;
    }

    public void setPerFacet(List<String> perFacet)
    {
        this.perFacet = perFacet;
    }

    public String getSubsection()
    {
        return subsection;
    }

    public void setSubsection(String subsection)
    {
        this.subsection = subsection;
    }

    public String getItemType()
    {
        return itemType;
    }

    public void setItemType(String itemType)
    {
        this.itemType = itemType;
    }

    public List<String> getOrgFacet()
    {
        return orgFacet;
    }

    public void setOrgFacet(List<String> orgFacet)
    {
        this.orgFacet = orgFacet;
    }

    public String getSection()
    {
        return section;
    }

    public void setSection(String section)
    {
        this.section = section;
    }

    public String getJsonMemberAbstract()
    {
        return jsonMemberAbstract;
    }

    public void setJsonMemberAbstract(String jsonMemberAbstract)
    {
        this.jsonMemberAbstract = jsonMemberAbstract;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public List<String> getDesFacet()
    {
        return desFacet;
    }

    public void setDesFacet(List<String> desFacet)
    {
        this.desFacet = desFacet;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getShortUrl()
    {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl)
    {
        this.shortUrl = shortUrl;
    }

    public String getMaterialTypeFacet()
    {
        return materialTypeFacet;
    }

    public void setMaterialTypeFacet(String materialTypeFacet)
    {
        this.materialTypeFacet = materialTypeFacet;
    }

    public List<MultimediaItemOfTopStories> getMultimedia()
    {
        return multimedia;
    }

    public void setMultimedia(List<MultimediaItemOfTopStories> multimedia)
    {
        this.multimedia = multimedia;
    }

    public List<Object> getGeoFacet()
    {
        return geoFacet;
    }

    public void setGeoFacet(List<Object> geoFacet)
    {
        this.geoFacet = geoFacet;
    }

    public String getUpdatedDate()
    {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate)
    {
        this.updatedDate = updatedDate;
    }

    public String getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(String createdDate)
    {
        this.createdDate = createdDate;
    }

    public String getByline()
    {
        return byline;
    }

    public void setByline(String byline)
    {
        this.byline = byline;
    }

    public String getPublishedDate()
    {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate)
    {
        this.publishedDate = publishedDate;
    }

    public String getKicker()
    {
        return kicker;
    }

    public void setKicker(String kicker)
    {
        this.kicker = kicker;
    }

    @Override
    public String toString()
    {
        return
                "ResultsItemOfTopStories{" +
                        "per_facet = '" + perFacet + '\'' +
                        ",subsection = '" + subsection + '\'' +
                        ",item_type = '" + itemType + '\'' +
                        ",org_facet = '" + orgFacet + '\'' +
                        ",section = '" + section + '\'' +
                        ",abstract = '" + jsonMemberAbstract + '\'' +
                        ",title = '" + title + '\'' +
                        ",des_facet = '" + desFacet + '\'' +
                        ",url = '" + url + '\'' +
                        ",short_url = '" + shortUrl + '\'' +
                        ",material_type_facet = '" + materialTypeFacet + '\'' +
                        ",multimedia = '" + multimedia + '\'' +
                        ",geo_facet = '" + geoFacet + '\'' +
                        ",updated_date = '" + updatedDate + '\'' +
                        ",created_date = '" + createdDate + '\'' +
                        ",byline = '" + byline + '\'' +
                        ",published_date = '" + publishedDate + '\'' +
                        ",kicker = '" + kicker + '\'' +
                        "}";
    }
}
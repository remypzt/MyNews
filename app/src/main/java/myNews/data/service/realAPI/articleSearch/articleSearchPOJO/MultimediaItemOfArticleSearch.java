package myNews.data.service.realAPI.articleSearch.articleSearchPOJO;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class MultimediaItemOfArticleSearch {

	@SerializedName("mLegacyOfArticleSearch")
	private LegacyOfArticleSearch mLegacyOfArticleSearch;

	@SerializedName("subtype")
	private String subtype;

	@SerializedName("crop_name")
	private String cropName;

	@SerializedName("width")
	private int width;

	@SerializedName("rank")
	private int rank;

	@SerializedName("caption")
	private Object caption;

	@SerializedName("subType")
	private String subType;

	@SerializedName("credit")
	private Object credit;

	@SerializedName("type")
	private String type;

	@SerializedName("url")
	private String url;

	@SerializedName("height")
	private int height;

	public LegacyOfArticleSearch getLegacyOfArticleSearch() {
		return mLegacyOfArticleSearch;
	}

	public void setLegacyOfArticleSearch(LegacyOfArticleSearch legacyOfArticleSearch) {
		this.mLegacyOfArticleSearch = legacyOfArticleSearch;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Object getCaption() {
		return caption;
	}

	public void setCaption(Object caption) {
		this.caption = caption;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public Object getCredit() {
		return credit;
	}

	public void setCredit(Object credit) {
		this.credit = credit;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "MultimediaItemOfArticleSearch{" + "mLegacyOfArticleSearch = '" + mLegacyOfArticleSearch + '\'' + ",subtype = '" + subtype + '\'' + ",crop_name = '" + cropName + '\'' + ",width = '" + width + '\'' + ",rank = '" + rank + '\'' + ",caption = '" + caption + '\'' + ",subType = '" + subType + '\'' + ",credit = '" + credit + '\'' + ",type = '" + type + '\'' + ",url = '" + url + '\'' + ",height = '" + height + '\'' + "}";
	}
}
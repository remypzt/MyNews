package myNews.data.service.realAPI.articleSearch.articleSearchPOJO;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class LegacyOfArticleSearch {

	@SerializedName("widewidth")
	private int widewidth;

	@SerializedName("wideheight")
	private int wideheight;

	@SerializedName("wide")
	private String wide;

	@SerializedName("thumbnail")
	private String thumbnail;

	@SerializedName("thumbnailwidth")
	private int thumbnailwidth;

	@SerializedName("thumbnailheight")
	private int thumbnailheight;

	@SerializedName("xlarge")
	private String xlarge;

	@SerializedName("xlargewidth")
	private int xlargewidth;

	@SerializedName("xlargeheight")
	private int xlargeheight;

	public int getWidewidth() {
		return widewidth;
	}

	public void setWidewidth(int widewidth) {
		this.widewidth = widewidth;
	}

	public int getWideheight() {
		return wideheight;
	}

	public void setWideheight(int wideheight) {
		this.wideheight = wideheight;
	}

	public String getWide() {
		return wide;
	}

	public void setWide(String wide) {
		this.wide = wide;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getThumbnailwidth() {
		return thumbnailwidth;
	}

	public void setThumbnailwidth(int thumbnailwidth) {
		this.thumbnailwidth = thumbnailwidth;
	}

	public int getThumbnailheight() {
		return thumbnailheight;
	}

	public void setThumbnailheight(int thumbnailheight) {
		this.thumbnailheight = thumbnailheight;
	}

	public String getXlarge() {
		return xlarge;
	}

	public void setXlarge(String xlarge) {
		this.xlarge = xlarge;
	}

	public int getXlargewidth() {
		return xlargewidth;
	}

	public void setXlargewidth(int xlargewidth) {
		this.xlargewidth = xlargewidth;
	}

	public int getXlargeheight() {
		return xlargeheight;
	}

	public void setXlargeheight(int xlargeheight) {
		this.xlargeheight = xlargeheight;
	}

	@Override
	public String toString() {
		return "LegacyOfArticleSearch{" + "widewidth = '" + widewidth + '\'' + ",wideheight = '" + wideheight + '\'' + ",wide = '" + wide + '\'' + ",thumbnail = '" + thumbnail + '\'' + ",thumbnailwidth = '" + thumbnailwidth + '\'' + ",thumbnailheight = '" + thumbnailheight + '\'' + ",xlarge = '" + xlarge + '\'' + ",xlargewidth = '" + xlargewidth + '\'' + ",xlargeheight = '" + xlargeheight + '\'' + "}";
	}
}
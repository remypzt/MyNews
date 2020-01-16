package myNews.data.service.realAPI.articleSearch.articleSearchPOJO;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class HeadlineOfArticleSearch {

	@SerializedName("sub")
	private Object sub;

	@SerializedName("content_kicker")
	private Object contentKicker;

	@SerializedName("name")
	private String name;

	@SerializedName("main")
	private String main;

	@SerializedName("seo")
	private Object seo;

	@SerializedName("print_headline")
	private Object printHeadline;

	@SerializedName("kicker")
	private Object kicker;

	public Object getSub() {
		return sub;
	}

	public void setSub(Object sub) {
		this.sub = sub;
	}

	public Object getContentKicker() {
		return contentKicker;
	}

	public void setContentKicker(Object contentKicker) {
		this.contentKicker = contentKicker;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public Object getSeo() {
		return seo;
	}

	public void setSeo(Object seo) {
		this.seo = seo;
	}

	public Object getPrintHeadline() {
		return printHeadline;
	}

	public void setPrintHeadline(Object printHeadline) {
		this.printHeadline = printHeadline;
	}

	public Object getKicker() {
		return kicker;
	}

	public void setKicker(Object kicker) {
		this.kicker = kicker;
	}

	@Override
	public String toString() {
		return "HeadlineOfArticleSearch{" + "sub = '" + sub + '\'' + ",content_kicker = '" + contentKicker + '\'' + ",name = '" + name + '\'' + ",main = '" + main + '\'' + ",seo = '" + seo + '\'' + ",print_headline = '" + printHeadline + '\'' + ",kicker = '" + kicker + '\'' + "}";
	}
}
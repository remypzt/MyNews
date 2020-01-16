package myNews.data.service.realAPI.articleSearch.articleSearchPOJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class DocsItemOfArticleSearch {

	@SerializedName("snippet")
	private String snippet;

	@SerializedName("keywords")
	private List<Object> keywords;

	@SerializedName("section_name")
	private String sectionName;

	@SerializedName("abstract")
	private String jsonMemberAbstract;

	@SerializedName("source")
	private String source;

	@SerializedName("uri")
	private String uri;

	@SerializedName("news_desk")
	private String newsDesk;

	@SerializedName("pub_date")
	private String pubDate;

	@SerializedName("multimedia")
	private List<MultimediaItemOfArticleSearch> multimedia;

	@SerializedName("word_count")
	private int wordCount;

	@SerializedName("lead_paragraph")
	private String leadParagraph;

	@SerializedName("type_of_material")
	private String typeOfMaterial;

	@SerializedName("web_url")
	private String webUrl;

	@SerializedName("_id")
	private String id;

	@SerializedName("mHeadlineOfArticleSearch")
	private HeadlineOfArticleSearch mHeadlineOfArticleSearch;

	@SerializedName("mBylineOfArticleSearch")
	private BylineOfArticleSearch mBylineOfArticleSearch;

	@SerializedName("document_type")
	private String documentType;

	@SerializedName("subsection_name")
	private String subsectionName;

	public String getSnippet() {
		return snippet;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	public List<Object> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<Object> keywords) {
		this.keywords = keywords;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
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

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getNewsDesk() {
		return newsDesk;
	}

	public void setNewsDesk(String newsDesk) {
		this.newsDesk = newsDesk;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public List<MultimediaItemOfArticleSearch> getMultimedia() {
		return multimedia;
	}

	public void setMultimedia(List<MultimediaItemOfArticleSearch> multimedia) {
		this.multimedia = multimedia;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

	public String getLeadParagraph() {
		return leadParagraph;
	}

	public void setLeadParagraph(String leadParagraph) {
		this.leadParagraph = leadParagraph;
	}

	public String getTypeOfMaterial() {
		return typeOfMaterial;
	}

	public void setTypeOfMaterial(String typeOfMaterial) {
		this.typeOfMaterial = typeOfMaterial;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HeadlineOfArticleSearch getHeadlineOfArticleSearch() {
		return mHeadlineOfArticleSearch;
	}

	public void setHeadlineOfArticleSearch(HeadlineOfArticleSearch headlineOfArticleSearch) {
		this.mHeadlineOfArticleSearch = headlineOfArticleSearch;
	}

	public BylineOfArticleSearch getBylineOfArticleSearch() {
		return mBylineOfArticleSearch;
	}

	public void setBylineOfArticleSearch(BylineOfArticleSearch bylineOfArticleSearch) {
		this.mBylineOfArticleSearch = bylineOfArticleSearch;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getSubsectionName() {
		return subsectionName;
	}

	public void setSubsectionName(String subsectionName) {
		this.subsectionName = subsectionName;
	}

	@Override
	public String toString() {
		return "DocsItemOfArticleSearch{" + "snippet = '" + snippet + '\'' + ",keywords = '" + keywords + '\'' + ",section_name = '" + sectionName + '\'' + ",abstract = '" + jsonMemberAbstract + '\'' + ",source = '" + source + '\'' + ",uri = '" + uri + '\'' + ",news_desk = '" + newsDesk + '\'' + ",pub_date = '" + pubDate + '\'' + ",multimedia = '" + multimedia + '\'' + ",word_count = '" + wordCount + '\'' + ",lead_paragraph = '" + leadParagraph + '\'' + ",type_of_material = '" + typeOfMaterial + '\'' + ",web_url = '" + webUrl + '\'' + ",_id = '" + id + '\'' + ",mHeadlineOfArticleSearch = '" + mHeadlineOfArticleSearch + '\'' + ",mBylineOfArticleSearch = '" + mBylineOfArticleSearch + '\'' + ",document_type = '" + documentType + '\'' + ",subsection_name = '" + subsectionName + '\'' + "}";
	}
}
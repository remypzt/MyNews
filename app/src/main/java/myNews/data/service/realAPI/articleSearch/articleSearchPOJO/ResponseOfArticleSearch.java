package myNews.data.service.realAPI.articleSearch.articleSearchPOJO;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ResponseOfArticleSearch {
	
	@SerializedName("copyright") private String   mCopyright;
	@SerializedName("response") private  Response mResponse;
	@SerializedName("status") private    String   mStatus;
	
	public String getCopyright() {
		return mCopyright;
	}
	
	public void setCopyright(String copyright) {
		mCopyright = copyright;
	}
	
	public Response getResponse() {
		return mResponse;
	}
	
	public void setResponse(Response response) {
		mResponse = response;
	}
	
	public String getStatus() {
		return mStatus;
	}
	
	public void setStatus(String status) {
		mStatus = status;
	}
	
}

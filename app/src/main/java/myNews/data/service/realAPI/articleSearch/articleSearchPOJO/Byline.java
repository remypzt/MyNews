package myNews.data.service.realAPI.articleSearch.articleSearchPOJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Byline {
	
	@SerializedName("organization") private Object       mOrganization;
	@SerializedName("original") private     String       mOriginal;
	@SerializedName("person") private       List<Person> mPerson;
	
	public Object getOrganization() {
		return mOrganization;
	}
	
	public void setOrganization(Object organization) {
		mOrganization = organization;
	}
	
	public String getOriginal() {
		return mOriginal;
	}
	
	public void setOriginal(String original) {
		mOriginal = original;
	}
	
	public List<Person> getPerson() {
		return mPerson;
	}
	
	public void setPerson(List<Person> person) {
		mPerson = person;
	}
	
}

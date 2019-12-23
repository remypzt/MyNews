package myNews.data.service.realAPI.articleSearch.articleSearchPOJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class BylineOfArticleSearch
{
    @SerializedName("original")
    private String original;

    @SerializedName("person")
    private List<PersonItemOfArticleSearch> person;

    @SerializedName("organization")
    private Object organization;

    public String getOriginal()
    {
        return original;
    }

    public void setOriginal(String original)
    {
        this.original = original;
    }

    public List<PersonItemOfArticleSearch> getPerson()
    {
        return person;
    }

    public void setPerson(List<PersonItemOfArticleSearch> person)
    {
        this.person = person;
    }

    public Object getOrganization()
    {
        return organization;
    }

    public void setOrganization(Object organization)
    {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return
                "BylineOfArticleSearch{" +
                        "original = '" + original + '\'' +
                        ",person = '" + person + '\'' +
                        ",organization = '" + organization + '\'' +
                        "}";
    }
}
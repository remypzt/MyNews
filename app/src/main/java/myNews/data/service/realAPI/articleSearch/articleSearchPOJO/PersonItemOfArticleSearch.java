package myNews.data.service.realAPI.articleSearch.articleSearchPOJO;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class PersonItemOfArticleSearch
{

    @SerializedName("firstname")
    private String firstname;

    @SerializedName("role")
    private String role;

    @SerializedName("qualifier")
    private Object qualifier;

    @SerializedName("organization")
    private String organization;

    @SerializedName("middlename")
    private Object middlename;

    @SerializedName("rank")
    private int rank;

    @SerializedName("title")
    private Object title;

    @SerializedName("lastname")
    private String lastname;

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public Object getQualifier()
    {
        return qualifier;
    }

    public void setQualifier(Object qualifier)
    {
        this.qualifier = qualifier;
    }

    public String getOrganization()
    {
        return organization;
    }

    public void setOrganization(String organization)
    {
        this.organization = organization;
    }

    public Object getMiddlename()
    {
        return middlename;
    }

    public void setMiddlename(Object middlename)
    {
        this.middlename = middlename;
    }

    public int getRank()
    {
        return rank;
    }

    public void setRank(int rank)
    {
        this.rank = rank;
    }

    public Object getTitle()
    {
        return title;
    }

    public void setTitle(Object title)
    {
        this.title = title;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    @Override
    public String toString()
    {
        return
                "PersonItemOfArticleSearch{" +
                        "firstname = '" + firstname + '\'' +
                        ",role = '" + role + '\'' +
                        ",qualifier = '" + qualifier + '\'' +
                        ",organization = '" + organization + '\'' +
                        ",middlename = '" + middlename + '\'' +
                        ",rank = '" + rank + '\'' +
                        ",title = '" + title + '\'' +
                        ",lastname = '" + lastname + '\'' +
                        "}";
    }
}
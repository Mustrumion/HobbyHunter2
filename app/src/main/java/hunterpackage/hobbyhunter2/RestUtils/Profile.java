package hunterpackage.hobbyhunter2.RestUtils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile
{
    @SerializedName("userID")
    @Expose
    private Integer userID;
    @SerializedName("iD")
    @Expose
    private Integer iD;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nameVisible")
    @Expose
    private Boolean nameVisible;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("surnameVisible")
    @Expose
    private Boolean surnameVisible;
    @SerializedName("gender")
    @Expose
    private Object gender;
    @SerializedName("genderVisible")
    @Expose
    private Boolean genderVisible;
    @SerializedName("nick")
    @Expose
    private String nick;
    @SerializedName("interests")
    @Expose
    private Object interests;
    @SerializedName("interestsVisible")
    @Expose
    private Boolean interestsVisible;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("descriptionVisible")
    @Expose
    private Boolean descriptionVisible;
    @SerializedName("born")
    @Expose
    private String born;
    @SerializedName("ageVisible")
    @Expose
    private Boolean ageVisible;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNameVisible() {
        return nameVisible;
    }

    public void setNameVisible(Boolean nameVisible) {
        this.nameVisible = nameVisible;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Boolean getSurnameVisible() {
        return surnameVisible;
    }

    public void setSurnameVisible(Boolean surnameVisible) {
        this.surnameVisible = surnameVisible;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public Boolean getGenderVisible() {
        return genderVisible;
    }

    public void setGenderVisible(Boolean genderVisible) {
        this.genderVisible = genderVisible;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Object getInterests() {
        return interests;
    }

    public void setInterests(Object interests) {
        this.interests = interests;
    }

    public Boolean getInterestsVisible() {
        return interestsVisible;
    }

    public void setInterestsVisible(Boolean interestsVisible) {
        this.interestsVisible = interestsVisible;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Boolean getDescriptionVisible() {
        return descriptionVisible;
    }

    public void setDescriptionVisible(Boolean descriptionVisible) {
        this.descriptionVisible = descriptionVisible;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public Boolean getAgeVisible() {
        return ageVisible;
    }

    public void setAgeVisible(Boolean ageVisible) {
        this.ageVisible = ageVisible;
    }

}

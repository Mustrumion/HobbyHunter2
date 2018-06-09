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
    private String gender;
    @SerializedName("genderVisible")
    @Expose
    private Boolean genderVisible;
    @SerializedName("nick")
    @Expose
    private String nick;
    @SerializedName("interests")
    @Expose
    private String interests;
    @SerializedName("interestsVisible")
    @Expose
    private Boolean interestsVisible;
    @SerializedName("description")
    @Expose
    private String description;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public Boolean getInterestsVisible() {
        return interestsVisible;
    }

    public void setInterestsVisible(Boolean interestsVisible) {
        this.interestsVisible = interestsVisible;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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


    public void copyDataFrom(Profile other){
        setAgeVisible(other.getAgeVisible());
        setBorn(other.getBorn());
        setDescription(other.getDescription());
        setDescriptionVisible(other.getDescriptionVisible());
        setGender(other.getGender());
        setGenderVisible(other.getGenderVisible());
        setID(other.getID());
        setInterests(other.getInterests());
        setInterestsVisible(other.getInterestsVisible());
        setName(other.getName());
        setNameVisible(other.getNameVisible());
        setNick(other.getNick());
        setSurname(other.getSurname());
        setSurnameVisible(other.getSurnameVisible());
        setUserID(other.getUserID());
    }

}

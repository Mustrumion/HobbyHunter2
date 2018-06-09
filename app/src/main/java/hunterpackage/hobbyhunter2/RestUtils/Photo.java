package hunterpackage.hobbyhunter2.RestUtils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("profileID")
    @Expose
    private Integer profileID;
    @SerializedName("userID")
    @Expose
    private Integer userID;
    @SerializedName("photoBase64")
    @Expose
    private String photoBase64;

    public Integer getProfileID() {
        return profileID;
    }

    public void setProfileID(Integer profileID) {
        this.profileID = profileID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getPhotoBase64() {
        return photoBase64;
    }

    public void setPhotoBase64(String photoBase64) {
        this.photoBase64 = photoBase64;
    }

}
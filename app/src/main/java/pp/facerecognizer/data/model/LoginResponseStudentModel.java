package pp.facerecognizer.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponseStudentModel {
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("avatar")
    @Expose
    private String avatar;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
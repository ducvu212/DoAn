package pp.facerecognizer.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponseDataModel {

    @SerializedName("student")
    @Expose
    private LoginResponseStudentModel student;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("class_id")
    @Expose
    private String classId;

    public LoginResponseStudentModel getStudent() {
        return student;
    }

    public void setStudent(LoginResponseStudentModel student) {
        this.student = student;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

}
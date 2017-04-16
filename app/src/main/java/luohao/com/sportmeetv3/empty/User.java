package luohao.com.sportmeetv3.empty;

import java.io.Serializable;

/**
 * Created by luohao3 on 2017/4/14.
 */

public class User implements Serializable{
    private int id;
    private String username;
    private String password;
    private String railname;
    private int collage;
    private String internetname;
    private int grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRailname() {
        return railname;
    }

    public void setRailname(String railname) {
        this.railname = railname;
    }

    public int getCollage() {
        return collage;
    }

    public void setCollage(int collage) {
        this.collage = collage;
    }

    public String getInternetname() {
        return internetname;
    }

    public void setInternetname(String internetname) {
        this.internetname = internetname;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", railname='" + railname + '\'' +
                ", collage='" + collage + '\'' +
                ", internetname='" + internetname + '\'' +
                ", grade=" + grade +
                '}';
    }
}

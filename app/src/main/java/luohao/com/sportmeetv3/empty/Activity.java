package luohao.com.sportmeetv3.empty;

import com.google.gson.Gson;

/**
 * Created by luohao3 on 2017/4/6.
 */

public class Activity {
    private int id;
    private int sendtime;
    private int user;
    private String msg;
    private boolean sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSendtime() {
        return sendtime;
    }

    public void setSendtime(int sendtime) {
        this.sendtime = sendtime;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

package luohao.com.sportmeetv3.empty;

import com.google.gson.Gson;

/**
 * Created by luohao on 2017/4/16.
 */

public class SignUp {
    private int id;
    private int activityid;
    private int userid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActivityid() {
        return activityid;
    }

    public void setActivityid(int activityid) {
        this.activityid = activityid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

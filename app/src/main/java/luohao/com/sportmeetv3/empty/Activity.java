package luohao.com.sportmeetv3.empty;

/**
 * Created by luohao3 on 2017/4/6.
 */

public class Activity {
    private int id;
    private int sendtime;
    private int user;
    private String msg;

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

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", sendtime=" + sendtime +
                ", user=" + user +
                ", msg='" + msg + '\'' +
                '}';
    }
}

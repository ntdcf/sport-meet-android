package luohao.com.sportmeetv3.empty;

import com.google.gson.Gson;

/**
 * Created by luohao on 2017/5/2.
 */

public class Result<E> {
    private int num;
    private boolean res;
    private String msg;
    private E data;

    public Result(int num, boolean res, String msg, E data) {
        this.num = num;
        this.res = res;
        this.msg = msg;
        this.data = data;
    }

    public int getNum() {
        return num;
    }

    public boolean isRes() {
        return res;
    }

    public String getMsg() {
        return msg;
    }

    public E getData() {
        return data;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

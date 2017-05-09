package luohao.com.sportmeetv3.service;

import com.google.gson.Gson;

import luohao.com.sportmeetv3.empty.Result;

/**
 * Created by luohao on 2017/5/2.
 */

public class BothService {
    public static final int SUCCESS = 1;
    public static final int FAILS = 0;

    public static String toJson(Result result) {
        return new Gson().toJson(result);
    }

    public static Result getResultClass(String Json) {
        return new Gson().fromJson(Json, Result.class);
    }
}

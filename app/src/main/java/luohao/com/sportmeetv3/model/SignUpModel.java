package luohao.com.sportmeetv3.model;

import android.content.DialogInterface;

import com.google.gson.Gson;
import com.google.gson.annotations.Since;
import com.google.gson.reflect.TypeToken;

import luohao.com.sportmeetv3.R;
import luohao.com.sportmeetv3.empty.Result;
import luohao.com.sportmeetv3.empty.SignUp;
import luohao.com.sportmeetv3.empty.User;
import luohao.com.sportmeetv3.service.LinkService;

/**
 * Created by luohao on 2017/5/9.
 */

public class SignUpModel {
    private String SignUpCountAPI = LinkService.ADDRESS_API+"countact";      //根据用户获取报名数量的API
    private String IsSignUpAPI = LinkService.ADDRESS_API+"issignup";    //根据报名信息查看该用户是否已经报过该项目
    private String SignUpAPI = LinkService.ADDRESS_API+"signup";        //报名接口
    private String UnSignUpAPI = LinkService.ADDRESS_API+"unsign";      //取消报名接口

    //获取该用户报名总数
    public int getSignUpCount(User user) throws InterruptedException {
        String res = LinkService.link(user.toString(), "POST", SignUpCountAPI);
        Result<Integer> result = new Gson().fromJson(res , new TypeToken<Result<Integer>>(){}.getType());
        return result.getData();
    }

    //该用户是否已经报过该项目
    public boolean getIsSignUp(SignUp signUp) throws InterruptedException {
        String res = LinkService.link(signUp.toString(), "POST", IsSignUpAPI);
        Result<Integer> result = new Gson().fromJson(res, new TypeToken<Result<Integer>>(){}.getType());
        return result.isRes();
    }

    //报名接口
    public boolean signUp(SignUp signUp) throws InterruptedException {
        String res = LinkService.link(signUp.toString(), "POST", SignUpAPI);
        Result result = new Gson().fromJson(res, Result.class);
        return result.isRes();
    }

    //取消报名接口操作
    public boolean unSignUp(SignUp signUp) throws InterruptedException {
        String res = LinkService.link(signUp.toString(), "POST", UnSignUpAPI);
        Result result = new Gson().fromJson(res, Result.class);
        return result.isRes();
    }
}

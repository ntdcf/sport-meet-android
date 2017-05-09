package luohao.com.sportmeetv3.service;

import java.util.ArrayList;
import java.util.List;

import luohao.com.sportmeetv3.empty.Activity;
import luohao.com.sportmeetv3.empty.SignUp;
import luohao.com.sportmeetv3.empty.User;
import luohao.com.sportmeetv3.model.ActivityModel;
import luohao.com.sportmeetv3.model.SignUpModel;

/**
 * Created by luohao on 2017/5/9.
 */

public class SignUpService {
    private SignUpModel signUpModel = new SignUpModel();
    private ActivityModel activityModel = new ActivityModel();

    public int getSignUpCount(User user) throws InterruptedException {
        return signUpModel.getSignUpCount(user);
    }

    public boolean isSignUp(SignUp signUp) throws InterruptedException {
        return signUpModel.getIsSignUp(signUp);
    }

    public boolean signUpUser(SignUp signUp) throws InterruptedException {
        return signUpModel.signUp(signUp);
    }

    public List<Activity> getActivity() {
        List<Activity> list = new ArrayList<Activity>();
        try {
            list = activityModel.getAllActivities();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }

    public List<Activity> getActivity(Activity activity) {
        List<Activity> activities = new ArrayList<Activity>();
        try {
            activities = activityModel.getActivity(activity);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return activities;
        }
    }

    public List<Activity> getActivity(User user) {
        List<Activity> activities = new ArrayList<Activity>();
        try {
            activities = activityModel.getActivity(user);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return activities;
        }
    }

    public boolean unSignUp(SignUp signUp) {
        boolean res = false;
        try {
            res = signUpModel.unSignUp(signUp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }
}

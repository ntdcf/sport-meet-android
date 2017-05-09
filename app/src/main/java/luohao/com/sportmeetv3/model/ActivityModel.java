package luohao.com.sportmeetv3.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import luohao.com.sportmeetv3.empty.Activity;
import luohao.com.sportmeetv3.empty.Result;
import luohao.com.sportmeetv3.empty.User;
import luohao.com.sportmeetv3.service.BothService;
import luohao.com.sportmeetv3.service.LinkService;

/**
 * Created by luohao on 2017/5/9.
 */

public class ActivityModel {
    private String AllActivitiesAPI = LinkService.ADDRESS_API+"getMsg";
    private String SearchActAPI = LinkService.ADDRESS_API+"searchact";
    private String GetSignedAPI = LinkService.ADDRESS_API+"getact";

    public List<Activity> getAllActivities() throws InterruptedException {
        String res = LinkService.link("", "POST", AllActivitiesAPI);
        Result<List<Activity>> result = new Gson().fromJson(res, new TypeToken<Result<List<Activity>>>(){}.getType());
        return result.getData();
    }

    public List<Activity> getActivity(Activity activity) throws InterruptedException {
        String res = LinkService.link(activity.toString(), "POST", SearchActAPI);
        Result<List<Activity>> result = new Gson().fromJson(res, new TypeToken<Result<List<Activity>>>(){}.getType());
        return result.getData();
    }

    public List<Activity> getActivity(User user) throws InterruptedException {
        String res = LinkService.link(user.toString(), "POST", GetSignedAPI);
        Result<List<Activity>> result = new Gson().fromJson(res, new TypeToken<Result<List<Activity>>>(){}.getType());
        return result.getData();
    }
}

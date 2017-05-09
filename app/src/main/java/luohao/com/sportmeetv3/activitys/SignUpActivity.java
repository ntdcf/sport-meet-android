package luohao.com.sportmeetv3.activitys;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import luohao.com.sportmeetv3.Adapter.ActivityAdapter;
import luohao.com.sportmeetv3.R;
import luohao.com.sportmeetv3.empty.Activity;
import luohao.com.sportmeetv3.empty.SignUp;
import luohao.com.sportmeetv3.empty.User;

import luohao.com.sportmeetv3.service.LinkService;
import luohao.com.sportmeetv3.service.SignUpService;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener, DialogInterface.OnClickListener{
    private ListView listitem;
    private User user;

    private EditText search;
    private Button searchButton;

    private ActivityAdapter adapter;
    private ActivityAdapter aapt;

    private List<Activity> list = new ArrayList<Activity>();
    private List<Activity> activities = new ArrayList<Activity>();

    private SignUpService signUpService = new SignUpService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        user = new Gson().fromJson(getIntent().getStringExtra("info"), User.class);

        listitem = (ListView) findViewById(R.id.sign_up_list);
        search = (EditText) findViewById(R.id.sign_up_edit_search);

        searchButton = (Button) findViewById(R.id.item_search_button);
        searchButton.setOnClickListener(this);

        list = signUpService.getActivity();
        adapter = new ActivityAdapter(SignUpActivity.this, R.layout.items_view, list);
        listitem.setAdapter(adapter);
        listitem.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_search_button:
                Activity activity = new Activity();
                activity.setMsg(search.getText().toString());
                activities = signUpService.getActivity(activity);
                final String[] atcs = new String[activities.size()];
                for (int i = 0; i <activities.size(); i++) {
                    atcs[i] = activities.get(i).getMsg();
                }
                aapt = new ActivityAdapter(
                        SignUpActivity.this,
                        R.layout.items_view,
                        activities);
                new AlertDialog.Builder(this)
                        .setTitle("搜索结果")
                        .setAdapter(aapt, this)
                        .show();
                break;
        }
    }

    //主页面点击事件
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        final Activity activity = list.get(i);

        final SignUp signUp = new SignUp();
        signUp.setActivityid(activity.getId());
        signUp.setUserid(user.getId());

        new AlertDialog.Builder(this)
                .setTitle("报名")
                .setMessage("确定要报名吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            judgeSignUp(user, signUp);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                })
                .setNegativeButton("取消", null)
                .show();
    }

    //弹出框点击事件
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        final Activity activity = activities.get(i);

        final SignUp signUp = new SignUp();
        signUp.setActivityid(activity.getId());
        signUp.setUserid(user.getId());

        new AlertDialog.Builder(this)
                .setTitle("报名")
                .setMessage("确定要报名吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            judgeSignUp(user, signUp);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                })
                .setNegativeButton("取消", null)
                .show();
    }

    //输出提示
    private void showPrompt(String info) {
        Toast.makeText(SignUpActivity.this, info, Toast.LENGTH_SHORT).show();
    }

    //报名过程判断
    private void judgeSignUp(User userinfo, SignUp signUpInfo) throws InterruptedException {
        if (signUpService.getSignUpCount(userinfo) < 5) {
            if (signUpService.isSignUp(signUpInfo)) {
                if (signUpService.signUpUser(signUpInfo)) {
                    showPrompt("报名成功！");
                } else {
                    showPrompt("报名失败，请重试");
                }
            } else {
                showPrompt("您已经报过此项目");
            }
        } else {
            showPrompt("最多报名5个项目，您已经够了哦");
        }
    }
}

package luohao.com.sportmeetv3.activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import luohao.com.sportmeetv3.Adapter.ActivityAdapter;
import luohao.com.sportmeetv3.R;
import luohao.com.sportmeetv3.empty.Activity;
import luohao.com.sportmeetv3.empty.SignUp;
import luohao.com.sportmeetv3.empty.User;
import luohao.com.sportmeetv3.service.LinkService;
import luohao.com.sportmeetv3.service.SignUpService;

public class SignedUpActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView ActivityItem;
    private List<Activity> activities;
    private User user;
    private String userInfo;

    private SignUpService signUpService = new SignUpService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signed_up);

        ActivityItem = (ListView) findViewById(R.id.signed_up_list);

        userInfo = getIntent().getStringExtra("info");
        user = new Gson().fromJson(userInfo, User.class);
        activities = signUpService.getActivity(user);

        ActivityAdapter activityAdapter = new ActivityAdapter(
                SignedUpActivity.this,
                R.layout.items_view,
                activities
        );
        ActivityItem.setAdapter(activityAdapter);
        ActivityItem.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Activity activity = activities.get(i);
        final SignUp signUp = new SignUp();
        signUp.setUserid(user.getId());
        signUp.setActivityid(activity.getId());

        new AlertDialog.Builder(this)
                .setTitle("操作")
                .setMessage("取消报名？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (signUpService.unSignUp(signUp)) {
                            showPrompt("取消报名成功");
                            refresh(userInfo);
                            finish();
                        } else showPrompt("取消报名失败");
                    }
                })
                .setNegativeButton("取消", null)
                .show();
    }

    //输出提示
    private void showPrompt(String info) {
        Toast.makeText(SignedUpActivity.this, info, Toast.LENGTH_SHORT).show();
    }

    //刷新页面
    private void refresh(String info) {
        Intent intent = new Intent(SignedUpActivity.this, SignedUpActivity.class);
        intent.putExtra("info", info);
        startActivity(intent);
    }

}

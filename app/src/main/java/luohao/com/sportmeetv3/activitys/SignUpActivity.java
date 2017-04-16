package luohao.com.sportmeetv3.activitys;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import luohao.com.sportmeetv3.Adapter.ActivityAdapter;
import luohao.com.sportmeetv3.R;
import luohao.com.sportmeetv3.empty.Activity;
import luohao.com.sportmeetv3.empty.SignUp;
import luohao.com.sportmeetv3.service.LinkService;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener {
    private ListView listitem;
    private String username;

    private List<Activity> list = new ArrayList<Activity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username = getIntent().getStringExtra("username");

        listitem = (ListView) findViewById(R.id.sign_up_list);

        Gson items = new Gson();
        try {
            list = items.fromJson(
                    LinkService.link("null", "POST", LinkService.ADDRESS_API+"getMsg"),
                    new TypeToken<List<Activity>>(){}.getType()
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ActivityAdapter adapter = new ActivityAdapter(
                SignUpActivity.this,
                R.layout.items_view,
                list);
        listitem.setAdapter(adapter);
        listitem.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_info_change_user_info_button:

                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        final Activity activity = list.get(i);
        Toast.makeText(SignUpActivity.this, activity.getMsg(), Toast.LENGTH_SHORT).show();
        SignUp signUp = new SignUp();
        signUp.setActivityid(activity.getId());
//        signUp.setUserid();
        final String signupInfo = new Gson().toJson(signUp);
        new AlertDialog.Builder(this)
                .setTitle("报名")
                .setMessage("确定要报名吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            LinkService.link(signupInfo, "POST", LinkService.ADDRESS_API+"signup");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                })
                .setNegativeButton("取消", null)
                .show();
    }
}

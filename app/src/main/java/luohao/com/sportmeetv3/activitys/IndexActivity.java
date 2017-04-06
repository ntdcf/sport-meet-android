package luohao.com.sportmeetv3.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import luohao.com.sportmeetv3.R;
import luohao.com.sportmeetv3.service.LoginActService;

public class IndexActivity extends Activity implements View.OnClickListener{

    private TextView stuname;
    private TextView stunumb;

    private Button activity;
    private Button userinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_index);

        stuname = (TextView) findViewById(R.id.index_stu_name);
        stunumb = (TextView) findViewById(R.id.index_stu_num);

        activity = (Button) findViewById(R.id.index_item_sign_up);
        activity.setOnClickListener(this);

        userinfo = (Button) findViewById(R.id.index_user_info);
        userinfo.setOnClickListener(this);



        Bundle data = getIntent().getExtras();
        String username = data.getString("username");

        LoginActService users = new LoginActService();
        String UserInfo = null;
        JSONObject userjson = null;
        try {
            UserInfo = users.infoUser(username);
            System.out.println(UserInfo);
            userjson = new JSONObject(UserInfo);
            System.out.println(userjson.getString("railname"));
            stuname.setText("姓名："+userjson.getString("railname"));
            stunumb.setText("学号："+userjson.getString("username"));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.index_item_sign_up:
                intent = new Intent(IndexActivity.this, SignUpActivity.class);
                startActivity(intent);
                break;
            case R.id.index_user_info:
                intent = new Intent(IndexActivity.this, UserInfoActivity.class);
                startActivity(intent);
                break;
        }
    }
}

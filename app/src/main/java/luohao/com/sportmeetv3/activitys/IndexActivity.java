package luohao.com.sportmeetv3.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

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
    private Button weather;
    private Button signedAct;
    private Button sendMsg;

    private String username;
    private String UserInfo;

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

        weather = (Button) findViewById(R.id.index_weather);
        weather.setOnClickListener(this);

        signedAct = (Button) findViewById(R.id.index_item_signed_up);
        signedAct.setOnClickListener(this);

        sendMsg = (Button) findViewById(R.id.index_msg) ;
        sendMsg.setOnClickListener(this);

        Bundle data = getIntent().getExtras();
        username = data.getString("username");

        LoginActService users = new LoginActService();

        JSONObject userjson = null;
        try {
            UserInfo = users.infoUser(username);
            System.out.println(UserInfo);
            userjson = new JSONObject(UserInfo);

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
                intent.putExtra("info", UserInfo);
                startActivity(intent);
                break;
            case R.id.index_user_info:
                intent = new Intent(IndexActivity.this, UserInfoActivity.class);
                intent.putExtra("info", UserInfo);
                startActivity(intent);
                break;
            case R.id.index_weather:
                intent = new Intent(IndexActivity.this, WeatherActivity.class);
                startActivity(intent);
                break;
            case R.id.index_item_signed_up:
                intent = new Intent(IndexActivity.this, SignedUpActivity.class);
                intent.putExtra("info", UserInfo);
                startActivity(intent);
                break;
            case R.id.index_msg:
                intent = new Intent(IndexActivity.this, SendMsgActivity.class);
                intent.putExtra("info", UserInfo);
                startActivity(intent);
                break;
        }
    }
}

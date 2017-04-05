package luohao.com.sportmeetv3.activitys;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import luohao.com.sportmeetv3.R;
import luohao.com.sportmeetv3.service.LoginActService;

public class IndexActivity extends Activity {

    private TextView stuname;
    private TextView stunumb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_index);

        stuname = (TextView) findViewById(R.id.index_stu_name);
        stunumb = (TextView) findViewById(R.id.index_stu_num);

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
}

package luohao.com.sportmeetv3.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;

import luohao.com.sportmeetv3.R;
import luohao.com.sportmeetv3.service.LoginActService;

public class RegActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText username;
    private EditText password;
    private EditText enterpswd;
    private EditText railname;
    private Button reg;
    private Button reset;

    LoginActService loginActService = new LoginActService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        username = (EditText) findViewById(R.id.reg_username);
        password = (EditText) findViewById(R.id.reg_password);
        enterpswd = (EditText) findViewById(R.id.reg_password_en);
        railname = (EditText) findViewById(R.id.reg_railname);

        reg = (Button) findViewById(R.id.reg_button_reg);
        reg.setOnClickListener(this);
        reset = (Button) findViewById(R.id.reg_button_reset);
        reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.reg_button_reg:
                String un = username.getText().toString();
                String pswd = password.getText().toString();
                String epswd = enterpswd.getText().toString();
                String rname = railname.getText().toString();

                if (un.equals("") || pswd.equals("") || epswd.equals("") || rname.equals("")) {
                    Toast.makeText(RegActivity.this, "请正确输入", Toast.LENGTH_SHORT).show();
                    break;
                }

                if (!pswd.equals(epswd)) {
                    Toast.makeText(RegActivity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                    break;
                }
                try {
                    if (loginActService.regUser(un, pswd, rname)) {
                        intent = new Intent(RegActivity.this, IndexActivity.class);
                        Bundle data = new Bundle();
                        data.putString("username", un);
                        intent.putExtras(data);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(RegActivity.this, "注册不成功,可能该学号已经被注册过", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
    }
}

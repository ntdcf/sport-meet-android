package luohao.com.sportmeetv3.activitys;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;

import luohao.com.sportmeetv3.R;
import luohao.com.sportmeetv3.service.LoginActService;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText username;
    private EditText password;
    private Button login;
    private Button reset;
    private Button reg;

    LoginActService loginActService = new LoginActService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.login_username);
        password = (EditText) findViewById(R.id.login_password);

        login = (Button) findViewById(R.id.login_button_enter);
        reset = (Button) findViewById(R.id.login_button_reset);
        reg = (Button) findViewById(R.id.login_button_reg);

        login.setOnClickListener(this);
        reset.setOnClickListener(this);
        reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.login_button_enter:
                String un = username.getText().toString();
                String pw = password.getText().toString();
                if (loginActService.issetLogin(un,pw)) {
                    try {
                        if (loginActService.loginUser(un, pw)) {
                            intent = new Intent(LoginActivity.this, IndexActivity.class);
                            Bundle data = new Bundle();
                            data.putString("username", un);
                            intent.putExtras(data);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "用户名或密码输入错误", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "请正确输入", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.login_button_reset:
                username.setText("");
                password.setText("");
                break;
            case R.id.login_button_reg:
                intent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(intent);
        }
    }
}

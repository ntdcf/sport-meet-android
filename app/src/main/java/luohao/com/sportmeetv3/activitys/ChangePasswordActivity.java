package luohao.com.sportmeetv3.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import luohao.com.sportmeetv3.R;

public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText passwordold;
    private EditText passwordnew;
    private EditText enterpswdnew;

    private Button changepswdbutton;
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        passwordold = (EditText) findViewById(R.id.change_password_old_edit);
        passwordnew = (EditText) findViewById(R.id.change_password_new_edit);
        enterpswdnew = (EditText) findViewById(R.id.change_password_enter_new_edit);

        changepswdbutton = (Button) findViewById(R.id.enter_change_password);
        changepswdbutton.setOnClickListener(this);
        reset = (Button) findViewById(R.id.reset_change_passowrd);
        reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.enter_change_password:
                String passwordoldtext = passwordold.getText().toString();
                String passwordnewtext = passwordnew.getText().toString();
                String enterpswdnewtext = enterpswdnew.getText().toString();
                if (passwordnewtext.equals("") || passwordoldtext.equals("") ||enterpswdnewtext.equals("")) {
                    Toast.makeText(ChangePasswordActivity.this, "请完整输入", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (!passwordnewtext.equals(enterpswdnewtext)) {
                    Toast.makeText(ChangePasswordActivity.this, "新密码两次输入不一致", Toast.LENGTH_SHORT).show();
                    break;
                }

                break;
            case R.id.reset_change_passowrd:
//                passwordold.setText("");
//                passwordnew.setText("");
//                enterpswdnew.setText("");
                finish();
                break;
        }
    }
}

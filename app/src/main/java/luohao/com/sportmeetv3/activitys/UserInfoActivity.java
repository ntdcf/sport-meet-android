package luohao.com.sportmeetv3.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import luohao.com.sportmeetv3.Adapter.CollageItem;
import luohao.com.sportmeetv3.R;
import luohao.com.sportmeetv3.empty.Collage;
import luohao.com.sportmeetv3.empty.User;
import luohao.com.sportmeetv3.service.LinkService;


public class UserInfoActivity extends AppCompatActivity implements View.OnClickListener{
    private String grade[] = {"13","14","15","16"};

    private Spinner gradeSpinner;
    private Spinner collageSpinner;

    private TextView usrename;
    private TextView railname;
    private TextView internetname;

    private Button changPasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        String UserInfo = getIntent().getStringExtra("info");
        User user = new Gson().fromJson(UserInfo, User.class);

        usrename = (TextView) findViewById(R.id.user_info_username_edit);
        usrename.setText(user.getUsername());

        railname = (EditText) findViewById(R.id.user_info_railname_edit);
        railname.setText(user.getRailname());

        internetname = (EditText) findViewById(R.id.user_info_intnetname_edit);
        internetname.setText(user.getInternetname());


        List<Collage> list = null;
        //在活动上铺数据，学院信息
        Gson collagegson = new Gson();
        try {
            list = collagegson.fromJson(
                    LinkService.link("", "POST", LinkService.ADDRESS_API+"usercollage"),
                    new TypeToken<List<Collage>>(){}.getType()
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        CollageItem collageAdapter = new CollageItem(
                UserInfoActivity.this,
                R.layout.collage_item,
                list
        );
        collageSpinner = (Spinner) findViewById(R.id.user_info_collage_select);
        collageSpinner.setAdapter(collageAdapter);
        //年级信息
        gradeSpinner = (Spinner) findViewById(R.id.user_info_grade_edit);
        ArrayAdapter<String> gradeAdapter = new ArrayAdapter<String>(
                UserInfoActivity.this,
                R.layout.support_simple_spinner_dropdown_item,
                grade);
        gradeSpinner.setAdapter(gradeAdapter);

        changPasswordButton = (Button) findViewById(R.id.user_info_change_password_button);
        changPasswordButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.user_info_change_password_button:
                intent = new Intent(UserInfoActivity.this, ChangePasswordActivity.class);
                startActivity(intent);
                break;
        }
    }
}

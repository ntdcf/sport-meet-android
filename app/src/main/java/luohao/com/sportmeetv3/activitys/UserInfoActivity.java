package luohao.com.sportmeetv3.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import luohao.com.sportmeetv3.Adapter.CollageItem;
import luohao.com.sportmeetv3.R;
import luohao.com.sportmeetv3.empty.Collage;
import luohao.com.sportmeetv3.empty.User;
import luohao.com.sportmeetv3.service.LinkService;


public class UserInfoActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {
    private String grade[] = {"13","14","15","16"};

    private Spinner gradeSpinner;
    private Spinner collageSpinner;

    private TextView usrename;
    private TextView railname;
    private EditText internetname;

    private Button changPasswordButton;
    private Button changUserInfoButton;

    private User user;
    private List<Collage> list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        String UserInfo = getIntent().getStringExtra("info");
        //重新获取到用户信息
        try {
            UserInfo = LinkService.link(UserInfo, "POST", LinkService.ADDRESS_API+"getuser");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        user = new Gson().fromJson(UserInfo, User.class);

        usrename = (TextView) findViewById(R.id.user_info_username_edit);
        usrename.setText(user.getUsername());

        railname = (TextView) findViewById(R.id.user_info_railname_edit);
        railname.setText(user.getRailname());

        internetname = (EditText) findViewById(R.id.user_info_intnetname_edit);
        internetname.setText(user.getInternetname());

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

        int index = 0;
        for (int i = 0; list.get(i).getId() != user.getCollage(); i++) {
            index++;
        }

        collageSpinner = (Spinner) findViewById(R.id.user_info_collage_select);
        collageSpinner.setAdapter(collageAdapter);
        collageSpinner.setSelection(index, true);
        collageSpinner.setOnItemSelectedListener(this);

        //年级信息
        gradeSpinner = (Spinner) findViewById(R.id.user_info_grade_edit);
        ArrayAdapter<String> gradeAdapter = new ArrayAdapter<String>(
                UserInfoActivity.this,
                R.layout.support_simple_spinner_dropdown_item,
                grade);
        gradeSpinner.setAdapter(gradeAdapter);
        index = 0;

        for (int i = 0; !grade[i].equals(String.valueOf(user.getGrade())); i++) {
            index++;
        }

        gradeSpinner.setSelection(index, true);
        gradeSpinner.setOnItemSelectedListener(this);

        changPasswordButton = (Button) findViewById(R.id.user_info_change_password_button);
        changPasswordButton.setOnClickListener(this);

        changUserInfoButton = (Button) findViewById(R.id.user_info_change_user_info_button);
        changUserInfoButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.user_info_change_password_button:
                intent = new Intent(UserInfoActivity.this, ChangePasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.user_info_change_user_info_button:
                user.setRailname(railname.getText().toString());
                user.setInternetname(internetname.getText().toString());
                String res = null;
                try {
                    res = LinkService.link(new Gson().toJson(user), "POST", LinkService.ADDRESS_API+"edituser");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (res.equals("1")) {
                    Toast.makeText(UserInfoActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UserInfoActivity.this, "修改失败", Toast.LENGTH_SHORT).show();
                }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()) {
            case R.id.user_info_collage_select:
                Collage collage = list.get(i);
                user.setCollage(collage.getId());
                break;
            case R.id.user_info_grade_edit:
                user.setGrade(Integer.parseInt(grade[i]));
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

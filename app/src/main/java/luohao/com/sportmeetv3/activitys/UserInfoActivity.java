package luohao.com.sportmeetv3.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import luohao.com.sportmeetv3.R;


public class UserInfoActivity extends AppCompatActivity {
    private String grade[] = {"13","14","15","16"};
    private Spinner gradeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        gradeSpinner = (Spinner) findViewById(R.id.user_info_grade_edit);

        ArrayAdapter<String> gradeAdapter = new ArrayAdapter<String>(
                UserInfoActivity.this,
                R.layout.support_simple_spinner_dropdown_item,
                grade);
        gradeSpinner.setAdapter(gradeAdapter);
    }
}

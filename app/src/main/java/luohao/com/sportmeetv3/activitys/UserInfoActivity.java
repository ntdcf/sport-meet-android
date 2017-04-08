package luohao.com.sportmeetv3.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import luohao.com.sportmeetv3.Adapter.CollageItem;
import luohao.com.sportmeetv3.R;
import luohao.com.sportmeetv3.empty.Collage;
import luohao.com.sportmeetv3.service.LinkService;


public class UserInfoActivity extends AppCompatActivity {
    private String grade[] = {"13","14","15","16"};
    private Spinner gradeSpinner;

    private Spinner collageSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);


        JSONArray collageData = null;
        List<Collage> list = null;
        Gson collagegson = new Gson();
        try {
            collageData = new JSONArray();
            list = collagegson.fromJson(
                    LinkService.link("", "POST", LinkService.ADDRESS_API+"usercollage"),
                    new TypeToken<List<Collage>>(){}.getType()
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        List<String> cm = new ArrayList<String>();
//        for (Collage c : list) cm.add(c.getName());
        CollageItem collageAdapter = new CollageItem(
                UserInfoActivity.this,
                R.layout.collage_item,
                list
        );
        collageSpinner = (Spinner) findViewById(R.id.user_info_collage_select);
        collageSpinner.setAdapter(collageAdapter);

        gradeSpinner = (Spinner) findViewById(R.id.user_info_grade_edit);
        ArrayAdapter<String> gradeAdapter = new ArrayAdapter<String>(
                UserInfoActivity.this,
                R.layout.support_simple_spinner_dropdown_item,
                grade);
        gradeSpinner.setAdapter(gradeAdapter);
    }
}

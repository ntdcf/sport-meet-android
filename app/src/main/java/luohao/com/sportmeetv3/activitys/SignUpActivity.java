package luohao.com.sportmeetv3.activitys;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import luohao.com.sportmeetv3.Adapter.ActivityAdapter;
import luohao.com.sportmeetv3.R;
import luohao.com.sportmeetv3.empty.Activity;
import luohao.com.sportmeetv3.service.LinkService;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView listitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        listitem = (ListView) findViewById(R.id.sign_up_list);


        List<Activity> list = null;
        Gson items = new Gson();
        try {
            System.out.println(LinkService.link("null", "POST", LinkService.ADDRESS_API+"getMsg"));
            list = items.fromJson(
                    LinkService.link("null", "POST", LinkService.ADDRESS_API+"getMsg"),
                    new TypeToken<List<Activity>>(){}.getType()
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ActivityAdapter adapter = new ActivityAdapter(
                SignUpActivity.this,
                R.layout.items_view,
                list);
        listitem.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_search:

        }
    }
}

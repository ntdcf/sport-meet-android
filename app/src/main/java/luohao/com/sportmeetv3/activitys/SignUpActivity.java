package luohao.com.sportmeetv3.activitys;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

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

        JSONArray items = null;
        List<String> list = new ArrayList<String>();
        Activity activity = new Activity();
        JSONObject item = null;
        try {
            items = new JSONArray(LinkService.link("null", "POST", LinkService.ADDRESS_API+"getMsg"));
            for(int i = 0; i<items.length(); i++) {
                item =  items.getJSONObject(i);
                list.add(item.getString("msg"));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SignUpActivity.this, R.layout.support_simple_spinner_dropdown_item, list);
        listitem.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_search:

        }
    }
}

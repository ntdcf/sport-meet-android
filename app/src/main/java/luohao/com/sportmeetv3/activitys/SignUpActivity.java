package luohao.com.sportmeetv3.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;

import luohao.com.sportmeetv3.R;
import luohao.com.sportmeetv3.service.LinkService;

public class SignUpActivity extends AppCompatActivity {
    private ListView listitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        listitem = (ListView) findViewById(R.id.index_item_sign_up);

        JSONArray items;
        try {
            items = new JSONArray(LinkService.link("null", "POST", LinkService.ADDRESS_API+"getMsg"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

//        ArrayAdapter adapter = new ArrayAdapter(SignUpActivity.this, R.layout.support_simple_spinner_dropdown_item, );
    }
}

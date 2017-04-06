package luohao.com.sportmeetv3.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.List;

import luohao.com.sportmeetv3.R;
import luohao.com.sportmeetv3.empty.Activity;

/**
 * Created by luohao3 on 2017/4/6.
 */

public class ActivityAdapter extends ArrayAdapter<Activity> {

    private int resource;

    public ActivityAdapter(Context context, int resource, List<Activity> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Activity activity = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resource, null);
        Button itemName = (Button)view.findViewById(R.id.sport_item_name);
        Button itemTime = (Button)view.findViewById(R.id.sport_item_time);
        Button itemUser = (Button)view.findViewById(R.id.sport_item_user);
        itemName.setText("1111");
        itemTime.setText("1111");
        itemUser.setText("1111");
        return view;
    }
}

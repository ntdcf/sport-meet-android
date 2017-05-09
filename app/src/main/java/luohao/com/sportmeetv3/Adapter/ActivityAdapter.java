package luohao.com.sportmeetv3.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import luohao.com.sportmeetv3.R;
import luohao.com.sportmeetv3.empty.Activity;

/**
 * Created by luohao3 on 2017/4/6.
 */

public class ActivityAdapter extends ArrayAdapter<Activity> {
    private int resource;
    private int size;
    private List<Activity> list;

    public ActivityAdapter(Context context, int resource, List<Activity> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.size = objects.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Activity activity = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resource, null);
        TextView itemName = (TextView) view.findViewById(R.id.sport_item_name);
        TextView itemTime = (TextView) view.findViewById(R.id.sport_item_time);
        TextView itemUser = (TextView) view.findViewById(R.id.sport_item_user);
        if (position < size) {
            itemName.setText(activity.getMsg());
            itemTime.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date(activity.getSendtime())));
            itemUser.setText(String.valueOf(activity.getUser()));
        }
        return view;
    }

    public void setItemList(List<Activity> list) {
        this.list = list;
    }
}

package luohao.com.sportmeetv3.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import luohao.com.sportmeetv3.R;
import luohao.com.sportmeetv3.empty.Collage;

/**
 * Created by luohao on 2017/4/8.
 */

public class CollageItem extends ArrayAdapter<Collage> {
    private int resourceId;
    private int size;

    public CollageItem(Context context, int textViewResourceId, List<Collage> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
        size = objects.size();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Collage collage = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        TextView name = ((TextView) view.findViewById(R.id.collage_item_name));
        if (position < size) {
            name.setText(collage.getName());
        }
        return view;
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        Collage collage = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        TextView id = ((TextView) view.findViewById(R.id.collage_item_id));
        TextView name = ((TextView) view.findViewById(R.id.collage_item_name));
        if (position < size) {
            id.setText(String.valueOf(collage.getId()));
            name.setText(collage.getName());
        }
        return view;
    }
}

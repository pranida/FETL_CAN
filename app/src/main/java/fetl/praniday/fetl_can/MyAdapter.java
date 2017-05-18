package fetl.praniday.fetl_can;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Pranida.Y on 05/18/17.
 */

public class MyAdapter extends BaseAdapter{

    private Context context;
    private String[] iconString , titleString, detailString;
    private ImageView imageView;
    private TextView titleTextView , detailTextView;
    private  String detailShort;

    public MyAdapter(Context context,
                     String[] iconString,
                     String[] titleString,
                     String[] detailString) {
        this.context = context;
        this.iconString = iconString;
        this.titleString = titleString;
        this.detailString = detailString;
    }


    @Override
    public int getCount() {
        return titleString.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.listview_layout, parent,false);

        //Initial view
        imageView = (ImageView) view.findViewById(R.id.imvIcon);
        titleTextView = (TextView) view.findViewById(R.id.txtTitle);
        detailTextView = (TextView) view.findViewById(R.id.txtDetail );

        //Show Text

        titleTextView.setText(titleString[position]);


        if (detailString[position].length() > 30) {
            detailShort = detailString[position].substring(0, 30) + "...";

        } else {
            detailShort = detailString[position];
        }
        detailTextView.setText(detailShort);

        //show Img
        Picasso.with(context).load(iconString[position]).into(imageView);



        return view;
    }



}//main class

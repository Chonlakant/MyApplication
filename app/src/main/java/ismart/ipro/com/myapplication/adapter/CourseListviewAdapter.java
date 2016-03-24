package ismart.ipro.com.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ismart.ipro.com.myapplication.R;


public class CourseListviewAdapter extends BaseAdapter implements AdapterView.OnClickListener {

    private Context context;
    String[] title;
    int[] res;
    public CourseListviewAdapter(Context context, String[] title,int[] res) {
        this.context = context;
        this.title = title;
        this.res = res;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int position) {
        return title.length;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder mViewHolder = null;

        if (convertView == null) {

            LayoutInflater mInflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = mInflater.inflate(R.layout.item_course, parent, false);

            mViewHolder = new ViewHolder(convertView);


            mViewHolder.title.setText(title[position]);

           // mViewHolder.imageView.setBackgroundResource(res[position]);
            Picasso.with(context)
                    .load(res[position])
                    .into(mViewHolder.imageView);


        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }


    @Override
    public void onClick(View view) {

    }

    public class ViewHolder {


        TextView title;
        ImageView imageView;

        public ViewHolder(View row) {
            title = (TextView) row.findViewById(R.id.title_tv);
            imageView = (ImageView) row.findViewById(R.id.imageView);
        }
    }



}


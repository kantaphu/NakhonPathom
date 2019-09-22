package com.example.nakhonpathom.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.nakhonpathom.R;
import com.example.nakhonpathom.model.Place;

import java.util.List;

public class PlaceListAdapter extends ArrayAdapter<Place> {

    private Context mContext ;
    private int mResouce ;
    private List<Place> mPlaceList ;


    public PlaceListAdapter(Context context, int resource, List<Place> placeList) {
        super(context, resource, placeList);
        this.mContext = context ;
        this.mResouce = resource ;
        this.mPlaceList = placeList ;
    }

    @Override
    public View getView(int position, @Nullable View convertView,@Nullable ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = convertView;
        if (v == null)
        {
            v = inflater.inflate(mResouce,parent,false);
        }
        //เข้าถึงobject Place ตาม position ที่ ListView ขอมา
        Place place = mPlaceList.get(position);

        //กำหนดชื่อ สถานที่ ลงใน TextView (place_name_text_view)
        TextView placeNameTextView = v.findViewById(R.id.place_name_text_view);
        placeNameTextView.setText(place.name);

        //กำหนดชื่อ อำเภอ ลงใน Textview (district_text_view)
        TextView districtNameTextView = v.findViewById(R.id.district_text_view);
        districtNameTextView.setText("อำเภอ".concat(place.district));

        ImageView loloImageView = v.findViewById(R.id.logo_image_view);
        loloImageView.setImageResource(place.imageRes);

        return v ;
    }
}

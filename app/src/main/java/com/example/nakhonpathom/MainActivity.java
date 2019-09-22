package com.example.nakhonpathom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nakhonpathom.adapter.PlaceListAdapter;
import com.example.nakhonpathom.adapter.RecyclerViewAdapter;
import com.example.nakhonpathom.model.Place;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /*private String[] mPlaceList = new  String[]{
            "พระปฐมเจดีย์","พระราชวังสนามจันทร์","พิพิธภัณฑ์รถเก่า","ตลาดท่านา","ตลาดน้ำดอนหวาย"
    };*/

    private List<Place> mPlaceList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateData();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(
                MainActivity.this,
                R.layout.item_place,
                mPlaceList
        );

        LinearLayoutManager lm = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        //recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);

        /*
        //ทำการอ้างอิงไปยัง ListView ใน Layout file
        ListView placeListView = findViewById(R.id.place_list_view);
        //สร้าง adapter
        PlaceListAdapter adapter = new PlaceListAdapter(
                MainActivity.this, //context
                R.layout.item_place, // ระบุ layout สำหรับแต่ละ item ใน list
                //R.id.place_name_text_view, //ระบุ view ที่จะใส่ข้อมูลลงไปสำหรัลแต่ละ item
                mPlaceList //แหล่งข้อมูล(data source) ในที่นี้คือ array ของ
        );

        //เอา adapter ไปผูกกับ ListView โดยเรียกใช้ method setAdapter ของ ListView
        placeListView.setAdapter(adapter);

        //สร้าง Listener เพื่อระบุโค้ดการทำงาน เมื่อแต่ละ item ถูกคลิก
        placeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position , long l) {
                //อ่านชื่อสถานที่จากของ item ที่ถูกคลิกจากarray mPalceList มาเก็บลงตัวแปร placeName
                Place place = mPlaceList.get(position);
                String placeName = place.name;
                //แสดงชื่อสถานที่ออกมาใน toast
                Toast.makeText(MainActivity.this, placeName, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, PlaceDetailsActivity.class);
                intent.putExtra("name",place.name);
                intent.putExtra("image",place.imageRes);

                startActivity(intent);
            }
        });*/
    }

    private void populateData() {
        Place place = new Place("พระปฐมเจดีย์","เมือง",R.drawable.wat);
        mPlaceList.add(place);

        place = new Place("พระราชวังสนามจันทร์","เมือง",R.drawable.palace);
        mPlaceList.add(place);

        place = new Place("พิพิธภัณธ์รถเก่า","นครชัยศรี",R.drawable.car);
        mPlaceList.add(place);

        place = new Place("ตลาดท่านา","นครชัยศรี",R.drawable.thana);
        mPlaceList.add(place);

        place = new Place("ตลาดน้ำลำพญา","บางเลน",R.drawable.lam);
        mPlaceList.add(place);

    }
}

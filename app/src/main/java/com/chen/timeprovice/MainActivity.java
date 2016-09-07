package com.chen.timeprovice;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aigestudio.wheelpicker.widgets.DatePick;
import com.aigestudio.wheelpicker.widgets.ProvincePick;
import com.chen.timeprovice.bean.CityVo;
import com.chen.timeprovice.bean.ProvinceVo;
import com.chen.timeprovice.util.TxtReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button test_btn, time_btn, city_btn;
    private ArrayList<ProvinceVo> provinceList;
    private ArrayList<CityVo> cityList;
    private ArrayList<String> provinceStrList;
    private HashMap<String,ArrayList<String>> cityStrList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        test_btn = (Button) findViewById(R.id.test_btn);
        time_btn = (Button) findViewById(R.id.time_btn);
        city_btn = (Button) findViewById(R.id.city_btn);
        provinceList = new ArrayList<>();
        cityList = new ArrayList<>();
        provinceStrList=new ArrayList<>();
        cityStrList=new HashMap<>();
        InputStream inputStream = getResources()
                .openRawResource(R.raw.cityinfo);
        TxtReader.getProvinceListAndCityList(inputStream, provinceList,
                cityList);
        ProvinceVo province;
        ArrayList<String> list;
        for (int i=0;i<provinceList.size();i++) {
            province=provinceList.get(i);
            provinceStrList.add(province.getProvinceName());
            list=getCityListByProviceCode(cityList,province.getProvincePostCode());
            cityStrList.put(province.getProvinceName(),list);
        }
        test_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PreviewActivity.class));
            }
        });
        time_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePick pickerPopWin = new DatePick.Builder(MainActivity.this, new DatePick.OnDatePickedListener() {
                    @Override
                    public void onDatePickCompleted(int year, int month, int day, String dateDesc) {
                        Toast.makeText(MainActivity.this, dateDesc, Toast.LENGTH_SHORT).show();
                    }
                }).textConfirm("CONFIRM") //text of confirm button
                        .textCancel("CANCEL") //text of cancel button
                        .btnTextSize(16) // button text size
                        .viewTextSize(25) // pick view text size
                        .colorCancel(Color.parseColor("#999999")) //color of cancel button
                        //.colorConfirm(getResources().getColor(R.color.colorAccent)//color of confirm button
                        .colorConfirm(Color.parseColor("#009900"))//color of confirm button
                        .minYear(1930) //min year in loop
                        .maxYear(2020) // max year in loop
                        .dateChose("2008-06-15") // date chose when init popwindow
                        .build();
                pickerPopWin.showPopWin(MainActivity.this);
            }
        });
        city_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProvincePick pickerPopWin = new ProvincePick.Builder(MainActivity.this,new ProvincePick.OnProCityPickedListener(){
                    @Override
                    public void onProCityPickCompleted(String province, String city, String dateDesc) {
                        Toast.makeText(MainActivity.this, dateDesc, Toast.LENGTH_SHORT).show();
                    }
                }).textConfirm("CONFIRM") //text of confirm button
                        .textCancel("CANCEL") //text of cancel button
                        .btnTextSize(16) // button text size
                        .viewTextSize(18) // pick view text size
                        .colorCancel(Color.parseColor("#999999")) //color of cancel button
                        .colorConfirm(Color.parseColor("#009900"))//color of confirm button
                        .setProvinceList(provinceStrList) //min year in loop
                        .setCityList(cityStrList) // max year in loop
                        .dateChose("浙江省-宁波市") // date chose when init popwindow
                        .build();
                pickerPopWin.showPopWin(MainActivity.this);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private  ArrayList<String> getCityListByProviceCode(ArrayList<CityVo>cityList,String provincePostCode){
        ArrayList<String>cityName=new ArrayList<>();
        for (CityVo cv : cityList) {
            if (cv.getProvincePostCode().equals(provincePostCode)) {
                cityName.add(cv.getCityName());
            }
        }
        return cityName;
    }

}

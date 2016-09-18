# MyPicker

提供时间和省市区选择的滚轮效果的选择器

学习网上的一些滚轮效果，自己拿个来作了部分修改，已将效果调整到比较好的地步

时间和日期都作了封装，使用方法如下

时间的选择器的使用
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
 
 
 
  省市的选择器
 ProvincePick provincePopWin = new ProvincePick.Builder(MainActivity.this,new ProvincePick.OnProCityPickedListener(){
 
  @Override

  public void onProCityPickCompleted(String province, String city, String dateDesc) {
  
  Toast.makeText(MainActivity.this, dateDesc, Toast.LENGTH_SHORT).show();
  
  }
  
  }).textConfirm("CONFIRM") //text of confirm button
  
  .textCancel("CANCEL") //text of cancel button
  
  .btnTextSize(16) // button text size
  
  .viewTextSize(25) // pick view text size
  
  .colorCancel(Color.parseColor("#999999")) //color of cancel button
  
  .colorConfirm(Color.parseColor("#009900"))//color of confirm button
 
  .setProvinceList(provinceStrList) //min year in loop
  
  .setCityList(cityStrList) // max year in loop
  
  .dateChose("浙江省-宁波市") // date chose when init popwindow

 .build();
 
  provincePopWin.showPopWin(MainActivity.this);
 
  目前只有2级联动，你也可以根据自己需要做到三级联动
  

![image](https://github.com/cheng7692019/MyPicker/blob/master/prew/haha.gif)



主要参考了https://github.com/AigeStudio/WheelPicker

 LICENSE

Copyright 2015-2017 MyPicker

Licensed under the Apache License, Version 2.0 (the "License");you may not use this file except in compliance with the License.

You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.



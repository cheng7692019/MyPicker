package com.chen.timeprovice.util;


import com.chen.timeprovice.bean.CityVo;
import com.chen.timeprovice.bean.ProvinceVo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;



public class TxtReader {

    /**
     * ͨ通过一个InputStream获取内容
     *
     * @param inputStream
     * @return
     */
    public static String getString(InputStream inputStream) {
        InputStreamReader inputStreamReader = null;
        try {
            //inputStreamReader = new InputStreamReader(inputStream, "gbk");
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuffer sb = new StringBuffer("");
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * ͨ通过一个InputStream分别对省的List及市的List进行赋值
     *
     * @param inputStream
     */
    public static void getProvinceListAndCityList(InputStream inputStream, List<ProvinceVo> provinceList, List<CityVo> cityList) {
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                //设一个临时数组
                String[] temp = null;
                temp = line.split(",");
                if (temp[0].equals("province")) {
                    ProvinceVo pVo = new ProvinceVo();
                    pVo.setProvinceName(temp[1]);
                    pVo.setProvincePostCode(temp[2]);
                    provinceList.add(pVo);
                } else if (temp[0].equals("city")) {
                    CityVo cVo = new CityVo();
                    cVo.setCityName(temp[1]);
                    cVo.setCityPostCode(temp[2]);
                    cVo.setProvincePostCode(temp[3]);
                    cityList.add(cVo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * ͨ通过txt文件的路径获取其内容
     *
     * @param filepath
     * @return
     */
    public static String getString(String filepath) {
        File file = new File(filepath);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return getString(fileInputStream);
    }
}

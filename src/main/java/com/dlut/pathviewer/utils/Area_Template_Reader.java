package com.dlut.pathviewer.utils;

public class Area_Template_Reader extends TemplateReader{
    public static String setArea(double lon1,double lat1,double lon2,double lat2){
        String re;
        re=currentTemplate.replace("@longitude1@",String.valueOf(lon1));
        re=re.replace("@longitude2@",String.valueOf(lon2));
        re=re.replace("@latitude1@",String.valueOf(lat1));
        re=re.replace("@latitude2@",String.valueOf(lat2));
        return re;
    }

}

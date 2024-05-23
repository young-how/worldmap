package com.dlut.pathviewer.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @projectName: worldmap
 * @package: com.dlut.pathviewer.utils
 * @className: RDTemplateReader
 * @author: younghow
 * @description: TODO
 * @date: 2024/5/23 12:45
 * @version: 1.0
 */
public class RDTemplateReader extends TemplateReader{
    private static String prefix="[\n" +
            "  {\n" +
            "    \"id\": \"document\",\n" +
            "    \"name\": \"CZML Geometries: Spheres and Ellipsoids\",\n" +
            "    \"version\": \"1.0\"\n" +
            "  }";  //前缀
    private static String suffix="]";  //后缀
    private static String mids="";  //中间内容
    private static String singleRD_template;  //单个RD的模板
    private static int rd_num=0;  //雷达编号
    public static String readTemplate(String fileName){
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String text = content.toString();
        currentTemplate=text;
        singleRD_template=text;
        return text;
    }
    public static void AddRD(double longitude,double latitude,double height,double R_){
        //添加单个RD
        String rd=singleRD_template;
        rd=rd.replace("@num@",String.valueOf(++rd_num));
        rd=rd.replace("@longitude@",String.valueOf(longitude));
        rd=rd.replace("@latitude@",String.valueOf(latitude));
        rd=rd.replace("@height@",String.valueOf(height));
        rd=rd.replace("@R_@",String.valueOf(R_));
        mids=mids+","+rd;
    }
    public static String getRDs(){
        rd_num=0;
        String re=prefix+mids+suffix;
        mids="";
        return re;
    }
}

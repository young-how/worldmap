package com.dlut.pathviewer.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @projectName: worldmap
 * @package: com.dlut.pathviewer.utils
 * @className: TemplateReader
 * @author: younghow
 * @description: TODO
 * @date: 2024/5/23 12:46
 * @version: 1.0
 */
public class TemplateReader {
    public static String currentTemplate;  //当前的模型
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
        return text;
    }
}

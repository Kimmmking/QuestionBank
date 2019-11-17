package com.example.question_bank.api;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;

public class baiduapi {
    //设置APPID/AK/SK
    public static final String APP_ID = "17712908";
    public static final String API_KEY = "3TvcTfSPey2VkwaGt3bOeW72";
    public static final String SECRET_KEY = "TjhPUD6ffZK5PIGxTZZVHuFjBVbeHtqo";
    public static void main(String[] args) {
        // 初始化一个AipOcr
        AipOcr client;
        client = new AipOcr(
                APP_ID, API_KEY, SECRET_KEY );
        // 调用接口
        String path = "D:\\QuestionBank\\src\\main\\webapp\\img\\image.jpg";
        JSONObject res = client.basicAccurateGeneral(path, new HashMap<String, String>());
        JSONArray result = res.getJSONArray("words_result");
        for(int i=0;i<result.length();i++){
            JSONObject job = result.getJSONObject(i);
            String word=job.get("words").toString();
            System.out.println(word) ;
        }
    }
}


package com.h5190013.hilal_kacmaz_final.util;

import com.google.gson.Gson;
import com.h5190013.hilal_kacmaz_final.model.PhotographyModel;


public class ObjectUtil {
    public  static String photographyToJsonString(PhotographyModel photographyModel)
    {
        Gson gson = new Gson();
        return   gson.toJson(photographyModel);
    }
    public  static PhotographyModel jsonStringToPhotography(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,PhotographyModel.class);
    }
}
package com.jiefeng.ssm.util;

import java.io.File;

public class PathUtil {

    public static String getImgBasePath(){

        String os = System.getProperty("os.name");

        String basePath = "";
        if(os.toLowerCase().startsWith("win")){
            basePath = "D:" + File.separator + "graduation" + File.separator + "test" + File.separator
                    + "image";
//            D:\graduation\test\image
        }
        return basePath;
    }


    public static String getDocumentImageUrl(Integer documentId){
        String  imagePath = File.separator + documentId + File.separator;
        return imagePath;
    }

}

package com.jiefeng.ssm.util;

import java.io.File;

public class PathUtil {

    /**
     * 获取图片的根目录
     * @return
     */
    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "D:" + File.separator + "graduation" + File.separator + "repairs" + File.separator + "image" ;
        } else {
            basePath = File.separator + "home" + File.separator + "o2odir" + File.separator + "image";
        }
        return basePath;
    }

    /**
     * 生成图片的目录
     * @param repairsId
     * @return
     */
    public static String getImagePath(String repairsId) {
        String imagePath = File.separator + "upload"
                + File.separator + repairsId + File.separator;
        return imagePath;
    }
}

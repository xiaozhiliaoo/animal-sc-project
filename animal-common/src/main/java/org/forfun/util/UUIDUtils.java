package org.forfun.util;

import java.util.Random;
import java.util.UUID;


public class UUIDUtils {

    /**
     * 生成32位随机字符串
     *
     * @return
     */
    public static String getRandom32PK() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 获取随机数
     *
     * @return
     */
    public static String getRandomNumber(int size) {
        if (size <= 0) size = 6; //默认6位
        String firstRandString = "123456789"; //随机第一位字符串
        String randString = "0123456789"; //随机产生的字符串
        Random random = new Random(); //随机种子
        String rst = ""; //返回值
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                rst += firstRandString.charAt(random.nextInt(6));
            } else {
                rst += randString.charAt(random.nextInt(6));
            }
        }
        return rst;
    }
}

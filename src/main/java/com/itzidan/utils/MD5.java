package com.itzidan.utils;

import org.springframework.util.DigestUtils;

public class MD5 {
    final static String key="lswcly";
    /**
     * MD5方法
     * 
     * @param text 明文

     * @return 密文
     * @throws Exception
     */
    public static String md5(String text)  {
        //加密后的字符串
        String encodeStr= DigestUtils.md5DigestAsHex((text + key).getBytes());
        return encodeStr;
        }

    /**
     * MD5验证方法
     * 
     * @param text 明文
     * @param key 密钥
     * @param md5 密文
     * @return true/false
     * @throws Exception
     */
    public static boolean verify(String text,  String md5) throws Exception {
        //根据传入的密钥进行验证
        String md5Text = md5(text);
        if(md5Text.equalsIgnoreCase(md5))
        {
            return true;
        }

            return false;
    }

    public static void main(String[] args) {

    }
}
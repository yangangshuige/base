package com.base.library.utils;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 * AES加密解密工具类
 *
 * @author 成望
 * @version v 1.0
 * @ClassName: AESUtil
 * @date 2017年6月26日 下午2:43:04
 */
public class AESUtil {

    private static final String CRYPT_KEY = "todayin2018todayinYY";
    private static final String IV_STRING = "2018todayinparkYYY";

    /**
     * 加密
     *
     * @param content 加密内容
     * @return 密文
     * @throws Exception e
     */
    public static String encrypt(String content) {
        byte[] encryptedBytes = new byte[0];
        try {
            byte[] byteContent = content.getBytes("UTF-8");
            // 注意，为了能与 iOS 统一
            // 这里的 key 不可以使用 KeyGenerator、SecureRandom、SecretKey 生成
            byte[] enCodeFormat = CRYPT_KEY.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
            byte[] initParam = IV_STRING.getBytes();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
            // 指定加密的算法、工作模式和填充方式
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            encryptedBytes = cipher.doFinal(byteContent);
            // 同样对加密后数据进行 base64 编码
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("AES encrypt Exception,content = {},Exception = {}" + content);
        }

        return "new!!" + new BASE64Encoder().encode(encryptedBytes);
    }

    /**
     * 解密
     *
     * @param content 密文
     * @return 明文
     * @throws Exception e
     */
    public static String decrypt(String content) {
        // base64 解码
        content = content.substring(5); //截掉"new!!"
        try {
            byte[] encryptedBytes = new BASE64Decoder().decodeBuffer(content);
            byte[] enCodeFormat = CRYPT_KEY.getBytes();
            SecretKeySpec secretKey = new SecretKeySpec(enCodeFormat, "AES");
            byte[] initParam = IV_STRING.getBytes();
            IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            byte[] result = cipher.doFinal(encryptedBytes);

            return new String(result, "UTF-8");
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("AES decrypt Exception,content = {},Exception = {}" + content);
        }
        return null;
    }

}


package com.example.boot.util;


import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.util.*;

/**
 * Created
 * author:  lqk
 * 2019/7/31 11:51
 */
public class Md5Utils {

    /**
     * md5加密
     * @param string
     * @return
     */
    public static final String Md5Encode(String string) {
        String s = string == null ? "" : string;
        char hexDigists[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd','e', 'f'};
        try {
            byte[] strTemp = s.getBytes("UTF-8");   //获取二进制
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);         //执行加密
            byte[] md = mdTemp.digest();    //加密结果
            int j = md.length;              //结果长度
            char str[] = new char[j * 2];   //字符数组
            int k = 0;
            for (int i = 0; i < j; i++) {   //将二进制加密结果转化为字符
                byte byte0 = md[i];
                str[k++] = hexDigists[byte0 >>> 4 & 0xf];
                str[k++] = hexDigists[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 验证md5签名
     * @param signature
     * @param obj
     * @return
     */
    public static boolean validateSign(String signature,Object obj){
        if(!signature.equals(Md5Encode(obj.toString()))){
            return false;
        }
        return true;
    }


    /**
     * 除去数组中的空值
     *
     * @param map 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    public static Map<String, Object> paraFilter(Map<String, Object> map) {

        Map<String, Object> result = new HashMap<>();
        if (map == null || map.size() <= 0) {
            return result;
        }
        for (String key : map.keySet()) {
            Object obj = map.get(key);
            if (!StringUtils.isEmpty(obj)) {
                if (obj instanceof String) {
                    result.put(key, String.valueOf(obj));
                } else {
                    result.put(key, obj);
                }
            }
        }
        return result;
    }

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     *
     * @param map 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, Object> map) {

        List<String> keys = new ArrayList<String>(map.keySet());
        Collections.sort(keys);
        String prestr = "";
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = map.get(key).toString();
            if (i == keys.size() - 1) {             //拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;
    }


}

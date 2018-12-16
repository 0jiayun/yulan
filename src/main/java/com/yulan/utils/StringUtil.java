package com.yulan.utils;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 乱码转换
 * @author Administrator
 *
 */
public class StringUtil {
	public static String getEncoding(String str) {
		String encode = "GB2312";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s = encode;
				return s;
			}
		} catch (Exception exception) {
		}
		encode = "ISO-8859-1";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s1 = encode;
				return s1;
			}
		} catch (Exception exception1) {
		}
		encode = "UTF-8";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s2 = encode;
				return s2;
			}
		} catch (Exception exception2) {
		}
		encode = "GBK";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s3 = encode;
				return s3;
			}
		} catch (Exception exception3) {
		}
		return "";
	}
	public static String getUtf8(String string) throws UnsupportedEncodingException {

		if(string == null || string.length() <= 0){
				return null;
		}else{
			System.out.println(getEncoding(string));
			System.out.println(string);
			String utf8=new String(string.getBytes(getEncoding(string)),"gbk");
			System.out.println(utf8);
			System.out.println();
			return utf8;
		}

	}

    public static String setUtf8(String string) throws UnsupportedEncodingException {

        if(string == null || string.length() <= 0){
            return null;
        }else {
            System.out.println(getEncoding(string));
            System.out.println(string);
            String utf8 = new String(string.getBytes("GBK"), "ISO-8859-1");
            System.out.println(utf8);
            System.out.println();
            return utf8;
        }
    }

	/**
	 * 替换文本
	 * @param text 模板
	 * @param beReplaced 被取代的点
	 * @param replaces 取代的数据
	 * @return 取代后的文本
	 */
	public static String replace(String text,String beReplaced,List<Object> replaces) {
		Pattern pattern = Pattern.compile(beReplaced);
		Matcher matcher = pattern.matcher(text);
		String result = new StringBuffer(text).toString();
		int i=0;
		while (matcher.find()) {
			if(replaces.size()<i+1) {
				break;
			}
			if(replaces.get(i)==null) {
				replaces.add(i,"");
			}
			String replace = replaces.get(i).toString();
			result = result.replaceFirst(beReplaced,replace);
			i++;
		}
		return result;
	}
}

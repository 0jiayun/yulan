package com.yulan.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.sf.json.JSONObject;

import javax.xml.bind.DatatypeConverter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 蔡荣镔
 */
public class Token {

    /**
     * JWT的签发者
     */
    private static final String ISSURE="蔡荣镔";
    private static Map<String,Object> header=new HashMap<String,Object>(2);
    private static final String KEY="aslkdjflaskjdfiozjxkvnwolketuo2i3u54r32094ufrjdzilkcjnazoise78u908q22ejhfkdlzncvo2w835r4yhnds";

    static{
        header.put("typ","JWT");
        header.put("alg","HS256");
    }

    public static String createToken(Object object) {
        JSONObject json = JSONObject.fromObject(object);
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(KEY);

        JwtBuilder builder = Jwts.builder()
                .setHeader(header)
                .setPayload(json.toString())
                .signWith(signatureAlgorithm,apiKeySecretBytes);

        return builder.compact();
    }

    public static Object parseToken(String jwt,Class className) {
        Claims claims;
        try{
            claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(KEY))
                    .parseClaimsJws(jwt).getBody();
        } catch (Exception e) {
            return null;
        }
        String origin = claims.toString();

        Map<String,String> properties = new HashMap<>();
        origin = origin.replaceAll(" ","");
        if(origin.length()<=2)
            return null;
        origin = origin.substring(1,origin.length()-1);
        String[] proverbs = origin.split(",");
        for(String proverb:proverbs) {
            String[] entry = proverb.split("=");
            properties.put(entry[0],entry[1]);
        }
        return com.alibaba.fastjson.JSONObject.parseObject(com.alibaba.fastjson.JSONObject.toJSONString(properties),className);
    }

}

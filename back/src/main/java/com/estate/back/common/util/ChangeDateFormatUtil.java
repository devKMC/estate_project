package com.estate.back.common.util;



import java.util.Date;
import java.text.SimpleDateFormat;

public class ChangeDateFormatUtil {
    
    public static String changeYYMMDD(String original) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// DB의 현재 타입
        Date datetime = simpleDateFormat.parse(original);// String -> datetime으로 변경
        simpleDateFormat = new SimpleDateFormat("yy.MM.dd"); // writerDatetime 형태로 변환
        String writeDatetime = simpleDateFormat.format(datetime);// 형태 변경후 writeDatetime으로 전달 YYYY-MM-dd hh:mm:ss -> yy.MM.dd
        return writeDatetime;
    }

    public static String changeYYYYMMDD(String original) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = simpleDateFormat.parse(original);
        simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String writeDatetime = simpleDateFormat.format(datetime);
        return writeDatetime;
    }

    public static String changeYYMM(String original) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = simpleDateFormat.parse(original);
        simpleDateFormat = new SimpleDateFormat("yy-MM");
        String writeDatetime = simpleDateFormat.format(datetime);
        return writeDatetime;
    }
} 

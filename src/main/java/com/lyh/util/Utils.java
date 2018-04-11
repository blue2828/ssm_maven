package com.lyh.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public boolean isEmpty(String str){
        if(str.trim()==""||"".equals(str)) return true;
        else return false;
    }
    public String formatDateToStr(String str,Date date){
        String returnStr="";
        try{
            SimpleDateFormat spdf=new SimpleDateFormat(str);
            returnStr=spdf.format(date);
        }catch (RuntimeException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnStr;
    }
}

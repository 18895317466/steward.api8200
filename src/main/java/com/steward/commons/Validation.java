package com.steward.commons;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/3/11.
 */
public class Validation {
    //加油卡号格式验证
    private static final Pattern REGX_OILCARDNO = Pattern.compile("\\[0-9]{16}") ;
    public static boolean isOilCardNo(String cardId){
        return StringUtils.isNotEmpty(cardId) && REGX_OILCARDNO.matcher(cardId).matches() ;
    }
}

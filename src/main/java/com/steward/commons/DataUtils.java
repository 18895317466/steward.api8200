package com.steward.commons;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Calendar;
import java.util.UUID;

/**
 * 时间工具
 * @author mastercheng
 *
 */
public class DataUtils {
    private static final String ORDERNO_PREFIX = "CY" ;

    /**
     * 生成订单号码
     * 格式：订单号CY-日期-UUID（4位）
     * @return
     */
    public static String generateOrderNo(){
        String uuid = UUID.randomUUID().toString();
        return ORDERNO_PREFIX + DateFormatUtils.format(Calendar.getInstance(), "yyyyMMdd") + StringUtils.substring(uuid, uuid.length() - 4) ;
    }
}

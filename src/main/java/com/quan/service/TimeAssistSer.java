package com.quan.service;

import java.util.Date;

public interface TimeAssistSer {
    Date getDateTimeByString(String t);
    Date getDateByString(String t);
    String getStringByDate(Date dt);
    String getStringByDateTime(Date dt);

}

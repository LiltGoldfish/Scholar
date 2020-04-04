package com.quan.service;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class TimeAssistBiz implements TimeAssistSer{
	@Override
	public Date getDateTimeByString(String t){
		
		Date dt = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			dt = sdf.parse(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dt;
	}

	@Override
	public Date getDateByString(String t){
		
		Date dt = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dt = sdf.parse(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dt;
	}
	@Override
	public String getStringByDate(Date dt){
		String t = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		t = sdf.format(dt); 
		return t;
	}
	@Override
	public String getStringByDateTime(Date dt){
		String t = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		t = sdf.format(dt); 
		return t;
	}
}

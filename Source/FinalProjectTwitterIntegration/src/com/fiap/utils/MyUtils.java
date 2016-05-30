package com.fiap.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import twitter4j.Status;

public class MyUtils {

	public static boolean isNullOrEmpty(String text){
		if(text == null || text.isEmpty())
			return true;
		return false;
	}	

	public static String getLastWeekDateStart(){
		DateTimeFormatter format = DateTimeFormatter.ofPattern("uuuu-MM-dd");
		LocalDate date = getCalendarLastWeek().getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return date.format(format);
	}
	
	public static String getLastWeekDateEnd(){
		Calendar c = getCalendarLastWeek();
		c.add(Calendar.DATE, 6);
		LocalDate date = c.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return date.format(DateTimeFormatter.ofPattern("uuuu-MM-dd"));
	}
	
	private static Calendar getCalendarLastWeek(){
		Date date = new Date();
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
	    c.add(Calendar.DATE, -i - 7);
	    
	    return c;
	}
	
	public static List<String> getFirstAndLastName(List<Status> list){
		List<String> names = new ArrayList<>();
		for(Status status : list){
			String[] nameAuthor = status.getUser().getName().trim().split(" ");
			String nameFormmated = (nameAuthor.length > 1) ? nameAuthor[0] + " " + nameAuthor[nameAuthor.length - 1] : nameAuthor[0] ;
			names.add(status.getUser().getName() + " ======== " + nameFormmated);
		}
		return names.stream().distinct().collect(Collectors.toList());
	}
}	
	
	
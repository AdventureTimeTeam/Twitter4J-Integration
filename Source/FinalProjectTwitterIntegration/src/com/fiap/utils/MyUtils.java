package com.fiap.utils;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class MyUtils {

	public static boolean isNullOrEmpty(String text){
		if(text == null || text.isEmpty())
			return true;
		return false;
	}
	
	public static boolean isValidInteger(int value){
		return false;
	}
	
	public static List<String> buildMessageActionOptions(Menu menu){
		return null;
	}
	
	public static void showMessage(String title, Message message){
		String text = message.getMessage();
		MessageType type = message.getType();		
		title = (isNullOrEmpty(title)) ? "Twitter Integration" : title;
		
		JOptionPane.showInputDialog(null, text, title, type.getId());
	}
	
	public static String showSelectMessage(String title, Message message, Object[] options){
		String text = message.getMessage();
		MessageType type = message.getType();		
		title = (isNullOrEmpty(title)) ? "Twitter Integration" : title;
		
		String input = (String)JOptionPane.showInputDialog(null, text, title, type.getId(), null, options, null);
		return input;
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
}	
	
	
package com.fiap.utils;

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

}	
	
	
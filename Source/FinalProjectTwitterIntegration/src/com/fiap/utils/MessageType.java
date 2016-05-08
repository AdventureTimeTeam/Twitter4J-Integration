package com.fiap.utils;

import javax.swing.JOptionPane;

public enum MessageType {
	ERROR(JOptionPane.ERROR_MESSAGE), 
	SUCCESS(JOptionPane.INFORMATION_MESSAGE);

	private final int id;

	private MessageType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}

package com.fiap.utils;

public enum Message {

	MSG_01("Testing", MessageType.ERROR),
	MSG_02("Testing", MessageType.SUCCESS);
	
	private String message;
	private MessageType type;
	
	private Message(String message, MessageType type){
		this.message = message;
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}
}

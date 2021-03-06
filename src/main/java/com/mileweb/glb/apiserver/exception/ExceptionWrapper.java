package com.mileweb.glb.apiserver.exception;

public enum ExceptionWrapper {
	sucError_100;
	
	private String msg;
	private String code;
	
	public static final String DEFAULT_CODE = "0";
	
	private ExceptionWrapper() {
		int index = this.name().lastIndexOf("_");
		msg = this.name().substring(0, index);
		code = this.name().substring(index + 1, this.name().length());
	}
	
	public String getMsg() {
		return msg;
	}
	
	public String getCode() {
		return code;
	}
}

package com.mileweb.glb.apiserver.exception;

public class BizException extends Exception {
	private ExceptionWrapper exceptionWrapper;
	private Object[] param;
	public BizException(ExceptionWrapper exceptionWrapper, Object[] param) {
		super();
		this.exceptionWrapper = exceptionWrapper;
		this.param = param;
	}
	public ExceptionWrapper getExceptionWrapper() {
		return exceptionWrapper;
	}
	public void setExceptionWrapper(ExceptionWrapper exceptionWrapper) {
		this.exceptionWrapper = exceptionWrapper;
	}
	public Object[] getParam() {
		return param;
	}
	public void setParam(Object[] param) {
		this.param = param;
	}
}

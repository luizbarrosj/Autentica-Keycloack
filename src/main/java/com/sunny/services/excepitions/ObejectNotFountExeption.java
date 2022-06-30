package com.sunny.services.excepitions;

public class ObejectNotFountExeption  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ObejectNotFountExeption(String msg) {
		super(msg);
	}
	
  public ObejectNotFountExeption(String msg,Throwable cause) {
	  
	  super(msg,cause);
	  
  }
	
	
}

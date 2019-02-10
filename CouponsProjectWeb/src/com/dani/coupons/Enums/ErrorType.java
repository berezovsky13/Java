package com.dani.coupons.Enums;

public enum ErrorType {

	INVALID_USER(400), 
	USER_ERROR(400), 
	WRONG_INPUT(400), 
	DB_ERROR(500), 
	DATA_NOT_FOUND(500), 
	OUT_OF_STOCK_OR_EXPIRED(304), 
	START_DATE_BIGGER_THAN_END_DATE(400), 
	CANNOT_PARSE_DATE(304),
	GENERAL_ERROR(500), 
	ALREADY_EXISTS(501), 
	INVALID_AMOUNT(500);

	private final int InternalErrorCode;

	//private Constructor 
	
	private ErrorType(int internalErrorCode){
		this.InternalErrorCode = internalErrorCode;
	}

	public int getInternalErrorCode() {
		return InternalErrorCode;
	}
	
	
}

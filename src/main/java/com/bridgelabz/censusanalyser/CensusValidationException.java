package com.bridgelabz.censusanalyser;

public class CensusValidationException extends Exception{

	private int count, expectedCount;
	private String errorString;
	private ErrorType type;
	
	public enum ErrorType{COUNT_ERROR, FILE_ERROR, HEADER_ERROR};
	
	public CensusValidationException(int count, int expectedCount){
		this.count = count;
		this.expectedCount = expectedCount;
		this.type = ErrorType.COUNT_ERROR;
	}
	
	public CensusValidationException(String errorString) {
		this.errorString = errorString;
		this.type = ErrorType.FILE_ERROR;
	}
	
	public CensusValidationException(String errorString, int type) {
		this.type = ErrorType.values()[type];
		this.errorString = errorString;
	}
	
	@Override
	public String toString() {
		if(type == ErrorType.COUNT_ERROR)
			return ("CensusValidationException COUNT_ERROR: Records Lengths DO NOT MATCH. Records Length: " + this.count + ". Expected Length: " + this.expectedCount);
		else
			return "CensusValidationException " + type.name() + ": " + this.errorString;
	}
}

package com.bridgelabz.censusanalyser;

public class CensusValidationException extends Exception{

	private int count, expectedCount;
	private String errorString;
	private errorType type;
	
	public enum errorType{COUNT_ERROR, FILE_ERROR};
	
	public CensusValidationException(int count, int expectedCount){
		this.count = count;
		this.expectedCount = expectedCount;
		this.type = errorType.COUNT_ERROR;
	}
	
	public CensusValidationException(String errorString) {
		this.errorString = errorString;
		this.type = errorType.FILE_ERROR;
	}
	
	@Override
	public String toString() {
		if(type == errorType.COUNT_ERROR)
			return ("CensusValidationException: Records Lengths DO NOT MATCH. Records Length: " + this.count + ". Expected Length: " + this.expectedCount);
		else
			return "CensusValidationException: " + this.errorString;
	}
}

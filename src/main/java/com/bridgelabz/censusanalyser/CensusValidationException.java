package com.bridgelabz.censusanalyser;

public class CensusValidationException extends Exception{

	private int stateCodeCount, stateCensusCount;
	private String errorString;
	private errorType type;
	
	public enum errorType{COUNT_ERROR, FILE_ERROR};
	
	public CensusValidationException(int stateCodeCount, int stateCensusCount){
		this.stateCensusCount = stateCensusCount;
		this.stateCodeCount = stateCodeCount;
		this.type = errorType.COUNT_ERROR;
	}
	
	public CensusValidationException(String errorString) {
		this.errorString = errorString;
		this.type = errorType.FILE_ERROR;
	}
	
	@Override
	public String toString() {
		if(type == errorType.COUNT_ERROR)
			return ("CensusValidationException: Records Lengths DO NOT MATCH. State Codes Length: " + this.stateCodeCount + ". State Census Data: " + this.stateCensusCount);
		else
			return "CensusValidationException: " + this.errorString;
	}
}

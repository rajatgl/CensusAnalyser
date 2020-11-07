package com.bridgelabz.censusanalysertest;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.censusanalyser.CensusValidationException;
import com.bridgelabz.censusanalyser.StateCensusAnalyser;

public class StateCensusAnalyserTests {
	
	@Test
	public void givenStateCensusCSV_IfRecordsMatch_ThrowNoException() {
		StateCensusAnalyser analyzer = new StateCensusAnalyser();
		try {
			analyzer.validateCensusRecords("./asset/IndiaStateCensusData.csv");
		}
		catch(CensusValidationException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void givenStateCensusCSV_IfRecordsMismatch_ThrowsException() {
		StateCensusAnalyser analyzer = new StateCensusAnalyser();
		try {
			analyzer.validateCensusRecords("./asset/IndiaStateCode.csv");
			Assert.fail();
		}
		catch(CensusValidationException e) {}
	}
	
	@Test
	public void givenStateCensusCSV_IfIncorrectType_ThrowsException() {
		StateCensusAnalyser analyzer = new StateCensusAnalyser();
		try {
			analyzer.validateCensusRecords("./asset/IndiaStateCode");
			Assert.fail();
		}
		catch(CensusValidationException e) {}
	}
	
	@Test
	public void givenStateCensusCSV_IfIncorrectHeader_ThrowsException() {
		StateCensusAnalyser analyzer = new StateCensusAnalyser();
		try {
			analyzer.validateCensusRecords("./asset/IndiaStateCensusDataWrongHeader.csv");
			Assert.fail();
		}
		catch(CensusValidationException e) {}
	}
}

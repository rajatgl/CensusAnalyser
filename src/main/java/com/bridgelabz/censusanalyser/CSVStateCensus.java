package com.bridgelabz.censusanalyser;

public class CSVStateCensus {

	public static void main(String[] args) {
		try {
			StateCensusAnalyser analyser = new StateCensusAnalyser();
			analyser.validateStateCodeRecords("./asset/IndiaStateCode.csv");
			System.out.println("Census Validator.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

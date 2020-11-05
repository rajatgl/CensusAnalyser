package com.bridgelabz.censusanalyser;

public class CSVStateCensus {

	public static void main(String[] args) {
		try {
			StateCensusAnalyser analyser = new StateCensusAnalyser();
			analyser.validateCensusRecords();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

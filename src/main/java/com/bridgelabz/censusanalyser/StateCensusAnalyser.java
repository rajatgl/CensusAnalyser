package com.bridgelabz.censusanalyser;
import java.io.*;
import java.util.*; 
import com.opencsv.CSVReader;

public class StateCensusAnalyser 
{	
	//returns number of records read
	public int openFile(String filePath, boolean shouldPrint) throws Exception{
		
		int lineCount = 0;
		CSVReader reader = new CSVReader(new FileReader(filePath));
	    String line[];
	    Iterator<String[]> it = reader.iterator();
	    while (it.hasNext()) {
	       line = (String[]) it.next();
	       lineCount++;
	       if(shouldPrint) {
		       System.out.println(Arrays.toString(line));
		       System.out.println(" ");
	       }
	    }
	    reader.close();
	    return lineCount;
	}
	
	public void validateCensusRecords() throws CensusValidationException{
		
		int countStateCensus = 0;
		int expectedLength = 29;
		
		try {
			countStateCensus = openFile("./asset/IndiaStateCensusData.csv", false);
		}
		catch(Exception e) {
			throw new CensusValidationException("Could not open file. Check file address or type (should be CSV).");
		}
		
		if(countStateCensus != expectedLength) {
			throw new CensusValidationException(countStateCensus, expectedLength);
		}
	}
}

package com.bridgelabz.censusanalyser;
import java.io.*;
import java.util.*; 
import com.opencsv.CSVReader;

public class StateCensusAnalyser 
{	
	//returns number of records read
	public int readFile(String filePath) throws Exception{
		int lineCount = 0;
		CSVReader reader = new CSVReader(new FileReader(filePath));
	    Iterator<String[]> it = reader.iterator();
	    String[] lines;
	    while (it.hasNext()) {
	    	lines = (String[])it.next();
	        lineCount++;
	    }
	    reader.close();
	    return lineCount;
	}
	
	public void validateCensusRecords(String filePath) throws CensusValidationException{
		
		int countStateCensus = 0;
		int expectedLength = 30;
		
		if(!isCSV(filePath)) {
			throw new CensusValidationException("File is not a CSV type.");
		}
		try {
			countStateCensus = readFile(filePath);
		}
		catch(Exception e) {
			throw new CensusValidationException("Could not open file. Check file address or type (should be CSV).");
		}
		
		if(countStateCensus != expectedLength) {
			throw new CensusValidationException(countStateCensus, expectedLength);
		}
		
		try {
			if(!matchHeaderCensus(filePath)) {
				throw new CensusValidationException("Header did not match. Did you add the Census File itself?", 2);
			}
		}
		catch(Exception e) {
			throw new CensusValidationException("Header did not match. Did you add the Census File itself?", 2);
		}
	}
	public boolean isCSV(String filePath) {
		String pattern = ".+\\.csv";
		return filePath.matches(pattern);
	}
	
	public boolean matchHeaderCensus(String filePath) throws Exception{
		CSVReader reader = new CSVReader(new FileReader(filePath));
	    Iterator<String[]> it = reader.iterator();
	    String[] header = (String[])it.next();
	    
	    if(header[0].equals("State")
	    		&& header[1].equals("Population")
	    		&& header[2].equals("AreaInSqKm")
	    		&& header[3].equals("DensityPerSqKm"))
	    	return true;
	    else
	    	return false;
	}
}

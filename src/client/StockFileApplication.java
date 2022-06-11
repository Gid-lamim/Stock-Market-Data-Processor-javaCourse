package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

public class StockFileApplication {
	
	public static void main(String args[]) throws IOException{
		StockFileReader fr = new StockFileReader("table.csv");
		
		
		List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());		
		StockFileData fileData = new StockFileData();
		fileData.addData(dataResult);
		fileData.printData();
		System.out.println(dataResult.size());
	}
	
	public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines){
		List<HashMap<String, Double>> dataResult = new ArrayList<>();
		
		/*csv files are basically text files with data. Each line has a number of data. They are usually separated by comma.
			here we need to separate the lines into columns 
			we can use the method split. It's gonna return an array of strings  String [].
		*/
		
		for(String line : lines) { //for each item in the list, and the item is a String
			String [] values = line.split(",");
					
			int cnt = 0;
			//now I'm gonna create a hashMap to get all the values from the csv file.
			//A HashMap store items in "key/value" pairs
			HashMap<String, Double> headerValueMap = new HashMap<>();
			
			//now that we've split the line into columns, we need to convert (parse) the values from String to double 
			for(String value : values) {
				double valueDouble = Double.parseDouble(value);
				headerValueMap.put(headers.get(cnt), valueDouble); //it stores the values and associates them with their header.
				cnt++; //iterates the counter so it can get the next column header
			}
			
		}
		
		return dataResult;
	}
	
	
}

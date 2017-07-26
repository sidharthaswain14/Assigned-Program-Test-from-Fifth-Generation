package com.yahoo.finance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.yahoo.finance.beans.StockAndPrice;

public class PortfolioTracker {

	public Set<StockAndPrice> shortStockPrices(String path){
		List<Float> totalStockPrices = new ArrayList<Float>();
		Set<StockAndPrice> stokKeyAndValues = new TreeSet<StockAndPrice>();
		
		try {
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line1 = reader.readLine();
			while (line1 != null) {
				float totalStockPrice = 0;
				//System.out.println(line1);

				String[] stokAndStockValues = line1.split(",");
				for (String stokAndStockValue : stokAndStockValues) {
					String[] stockPrices = stokAndStockValue.split("-");

					for (int i = 0; i <= stockPrices.length; i++) {
						if (!(i % 2 == 0)) {
							totalStockPrice = totalStockPrice
									+ Float.parseFloat(stockPrices[i].trim());
						}
					}
				}
				totalStockPrices.add(totalStockPrice);
				stokKeyAndValues.add(new StockAndPrice(totalStockPrice,
						line1));
				line1 = reader.readLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("file not found please enter a valid file name or path");
		} catch (IOException e){
			e.printStackTrace();
			System.out.println("io exception occures while reading the line");
		}
	
		return stokKeyAndValues;
	}
	public static void main(String[] args) throws IOException {
		String path=null;
		Set<StockAndPrice> stockKeyAndValues;
		//String path = "E:/portfolio.txt";
		try{
		path=args[0];
		}catch(ArrayIndexOutOfBoundsException e){
			//e.printStackTrace();
			System.out.println("please pass a valid file via command line argument");
		}
		if(path!=null){
		stockKeyAndValues=new PortfolioTracker().shortStockPrices(path);
		
		for (StockAndPrice ssss : stockKeyAndValues) {
			System.out.println(ssss);
		}
		}
	}

}



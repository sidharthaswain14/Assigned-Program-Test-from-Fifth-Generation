package com.yahoo.finance;

import static org.junit.Assert.assertArrayEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import com.yahoo.finance.beans.StockAndPrice;
public class PortfolioTrackerTest {
	
	private static String INPUT_FILE_NM = "c:\\portfolio.txt";
	private PortfolioTracker tracker;
	private Set<StockAndPrice> expectedStocks;
	
	@Before
	public void init(){
		tracker=new PortfolioTracker();
		
		expectedStocks=new TreeSet<StockAndPrice>();
		expectedStocks.add(new StockAndPrice(270f, "GOOG-100,AMZN-90,MS-80"));
		expectedStocks.add(new StockAndPrice(160f, "SGI-100, GOOG - 50,MS - 10"));
		expectedStocks.add(new StockAndPrice(60f, "GOOG-50,MS - 10"));
		
		
		StringBuffer stocks=new StringBuffer();
		stocks.append("GOOG - 50, MS - 10");
		stocks.append(System.getProperty("line.separator"));
		stocks.append("SGI - 100, GOOG - 50, MS - 10");
		stocks.append(System.getProperty("line.separator"));
		stocks.append("GOOG - 100, AMZN - 90, MS - 80");
		
		try {
			FileOutputStream fos=new FileOutputStream(INPUT_FILE_NM);
			try {
				fos.write(stocks.toString().getBytes());
				fos.flush();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("file not found");
		}
		
		
	}
	
	@Test
	public void shortTest(){
		Set<StockAndPrice> actualStocks;
		actualStocks=tracker.shortStockPrices(INPUT_FILE_NM);
		assertArrayEquals(new Object[]{expectedStocks}, new Object[]{actualStocks});
		
	}
	
	//public void 
}

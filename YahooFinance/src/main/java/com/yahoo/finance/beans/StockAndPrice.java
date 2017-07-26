package com.yahoo.finance.beans;

//import com.yahoo.finance.SockAndPriceWithTotal;

@SuppressWarnings("rawtypes")
public class StockAndPrice implements Comparable {
		float totalStockPrice;
		String stocks;

		public StockAndPrice(float totalStockPrice, String stocks) {
			this.totalStockPrice = totalStockPrice;
			this.stocks = stocks;
		}

		public int compareTo(Object o) {

			float totalStockPrice1 = this.totalStockPrice;
			float totalStockPrice2 = ((StockAndPrice) o).totalStockPrice;

			if (totalStockPrice1 > totalStockPrice2) {
				return -1;
			} else if (totalStockPrice1 < totalStockPrice2) {
				return 1;
			} else {
				return 1;
			}

		}

		public float getTotalStockPrice() {
			return totalStockPrice;
		}

		public void setTotalStockPrice(float totalStockPrice) {
			this.totalStockPrice = totalStockPrice;
		}

		public String getStocks() {
			return stocks;
		}

		public void setStocks(String stocks) {
			this.stocks = stocks;
		}

		@Override
		public String toString() {
			return "[totalStockPrice=" + totalStockPrice
					+ "],  [ stocks=" + stocks + "]";
		}

	
}

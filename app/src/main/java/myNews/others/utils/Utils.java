package myNews.others.utils;

/**
 * Created by Remy Pouzet on 24/02/2020.
 */
public class Utils {
	
	public static String UIformat(int dayOfMonth,
	                              int monthOfYear,
	                              int year) {
		
		String dateInUIformat;
		
		dateInUIformat = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
		
		return dateInUIformat;
	}
	
	public static String BEformat(int dayOfMonth,
	                              int monthOfYear,
	                              int year) {
		
		String dateInBEformat;
		
		dateInBEformat = year + "0" + (monthOfYear + 1) + "" + dayOfMonth;
		
		return dateInBEformat;
	}
	
	public static String BEformatException(int dayOfMonth,
	                                       int monthOfYear,
	                                       int year) {
		
		String dateInBEformatException;
		
		dateInBEformatException = year + "0" + (monthOfYear + 1) + "0" + dayOfMonth;
		
		return dateInBEformatException;
	}
	
}

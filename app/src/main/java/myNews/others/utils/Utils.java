package myNews.others.utils;

/**
 * Created by Remy Pouzet on 24/02/2020.
 */
public class Utils {
	
	public static String UIformat(int dayOfMonth,
	                              int monthOfYear,
	                              int year) {
		
		String dateInUIformat = "";
		
		dateInUIformat = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
		
		return dateInUIformat;
	}
	
}

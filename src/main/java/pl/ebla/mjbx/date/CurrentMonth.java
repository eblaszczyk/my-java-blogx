package pl.ebla.mjbx.date;

import java.util.Calendar;
import java.util.Date;


public class CurrentMonth {

	private static String[] monthNames = {"Styczeñ", "Luty", "Marzec", "Kwiecieñ", 
										"Maj", "Czerwiec", "Lipiec", "Sierpieñ", 
										"Wrzesieñ", "PaŸdziernik", "Listopad", "Grudzieñ"};
	private Calendar cal;
	
	public CurrentMonth(){
		
		this.cal = Calendar.getInstance();
	}
	
	public CurrentMonth( int year, int month){
		
		this.cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
	}
	
	/*
	 * Dla PL zwraca niestety nazwy w dope³niaczu ....
	private static String[] initializeMonthNames(){
		
		DateFormatSymbols symbols = new DateFormatSymbols(Locale.getDefault());
		return symbols.getMonths();
	}*/

	public  String getMonthName(){
		
		return monthNames[cal.get(Calendar.MONTH)] +" " + cal.get(Calendar.YEAR);
	}
	
	public  Date getFirstDateOfMonth() {

		  cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		  cal.set(Calendar.HOUR_OF_DAY, 0);
		  cal.set(Calendar.MINUTE, 0);
		  cal.set(Calendar.SECOND, 0);

		  return cal.getTime();
	}
	
	public  Date getLastDateOfMonth() {

		  cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		  cal.set(Calendar.HOUR_OF_DAY, 23);
		  cal.set(Calendar.MINUTE, 59);
		  cal.set(Calendar.SECOND, 59);

		  return cal.getTime();
	}	
	
	public  int getMonthNumber(){
		
		return cal.get(Calendar.MONTH);
	}
	
	public int getYearNumber(){
		
		return cal.get(Calendar.YEAR);
	}
}

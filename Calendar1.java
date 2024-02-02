/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar1 {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	//static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable, used for debugging purposes, counts how many days were advanced so far.
	    int debugDaysCounter = 0;
		int sundayCounter = 0;
		String outS = "";
		boolean endCent= false;
	    //// goes through the dates till the end of the century
	 	while (!endCent) {

			//create a string to hold the date
			outS = dayOfMonth+ "/" + month + "/" + year;
			debugDaysCounter++;

	 		//// checks if its a sunday and if it is the 1st day of the month
	 		if ( dayOfWeek == 8) {
	 			outS += " Sunday";
				sundayCounter = (dayOfMonth == 1)? (sundayCounter+1): sundayCounter;
				dayOfWeek = 1;
	 		}

			 //increment dayofweek and prints the date and increments the date.
			 dayOfWeek++;
			 System.out.println(outS);
			 advance();
			 endCent = (year == 2000);
        }
		 System.out.println("During the 20th century, "+ sundayCounter + " Sundays fell on the first day of the month");
	 	//// Write the necessary ending code here
	 }
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {

		if(dayOfMonth <= nDaysInMonth(month , year))
			dayOfMonth++;
		if(dayOfMonth > nDaysInMonth(month,year)){
			dayOfMonth = 1;
			if(month == 12){
				year++;
				month = 1;
			}
			else
				month++;

		}
	 } 
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
		boolean isLeap = false;

		isLeap = (year % 400 == 0);
		isLeap = isLeap || ((year % 4 == 0) && (year % 100 !=0));

		return isLeap;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		//checks if leap year then february has 29 days
		if(isLeapYear(year) && month == 2){
			return 29;
		}

		//checks if the month is <= 7 the odd months has 31, the even has 30; febuary has 28;
		if(month <= 7 ){
			if(month == 2)
				return 28;

			return (month % 2 == 0)? 30 : 31;
		}

		//checks if the month is > 7 then the odd months has 30 days the even has 31;
		else {

			return(month % 2 == 0)? 31 : 30;
		}
	}

}
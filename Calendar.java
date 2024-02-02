public class Calendar {
    static int dayOfMonth = 1;
    static int month = 1;
    static int year = 1900;
    static int dayOfWeek = 2;

    public static void main(String args[]){
        int givenYear = Integer.parseInt(args[0]);
        int debugDaysCounter = 0;
        String outS = "";
        boolean endCent= false;

        //// goes through the dates till the start of the given year
        while (!endCent) {

            //create a string to hold the date
            debugDaysCounter++;

            //// checks if its a sunday and if it is the 1st day of the month
            if ( dayOfWeek == 8) {
                dayOfWeek = 1;
            }

            //increment dayofweek and prints the date and increments the date.
            dayOfWeek++;
            advance();
            endCent = (year == givenYear);
        }

        outS = dayOfMonth+ "/" + month + "/" + year;
        //prints the dates in the given year
        while(year == givenYear){

            //checks if sunday and reset day of week if so
            if ( dayOfWeek == 8) {
                outS += " Sunday";
                dayOfWeek = 1;
            }

            dayOfWeek++;

            System.out.println(outS);
            advance();
            outS = dayOfMonth+ "/" + month + "/" + year;
        }


    }


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


    private static boolean isLeapYear(int year) {
        boolean isLeap = false;

        isLeap = (year % 400 == 0);
        isLeap = isLeap || ((year % 4 == 0) && (year % 100 !=0));

        return isLeap;
    }

}

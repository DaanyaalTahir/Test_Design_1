package com.ontariotechu.sofe3980U;
import java.util.*;

/**
 * Main class for the Next Date Calculator
 *
 */
public class App 
{
    // ArrayList which contains the months that do not have 31 days
    private static ArrayList<Integer> monthNotWith31 = new ArrayList<Integer>(Arrays.asList(2, 4, 6, 9, 11));

    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in); // Initialize the scanner
        int year, month, day; // Declar variables

        // Menu system 
		System.out.println("\n=== Welcome to Next Date Calculator ===\n");

        // Get date input from user
        System.out.print("Enter the day (1-31): ");
		day = in.nextInt();  
        System.out.print("Enter the month (1-12): ");
		month = in.nextInt();  
        System.out.print("Enter the year (1812-2212): ");
		year = in.nextInt();  

        // Print result
        System.out.println("\nResult: " + GetNextDate(day, month, year));

        in.close();
    }

    /**
     * Given a day, month, and year return the next date given that the date is valid
     * @param day - integer day
     * @param month - integer month
     * @param year - integer year
     * 
     * @return A formatted string of the next date
     */
    public static String GetNextDate(int day, int month, int year){

        // Check to see if the given date is valid
        if(NotInDomain(day, month, year)){
            return "Invalid Date";
        }

        day++; // Increment the day

        // Check to see if the day is incremented, that the month remains the same, if so return the date with only an incremented day
        if( day == 29 && month == 2 && IsLeapYear(year) || day == 30 && month != 2 
            || day == 31 && !monthNotWith31.contains(month) || day < 29 && month != 2 
            || day < 28){
            return FormatDateAsString(day, month, year);
        }
        
        // Assume that the day transitions to the next month
        day = 1;
        month++;

        //  Check if an incremented month remains within the same year
        if(month <=12){
            return FormatDateAsString(day, month, year);
        }
        // If not increment the year as well
        return FormatDateAsString(day, month-12, year+1);
        
    }

    /**
     * Given a day, month, and year check to see if it is valid
     * @param day - integer day
     * @param month - integer month
     * @param year - integer year
     * 
     * @return Boolean representing whether a date is valid
     */
    private static boolean NotInDomain(int day, int month, int year){
        return day < 0 || day > 31 || month < 0 || month > 12 
        || year > 2212 || year < 1812 
        || day == 29 && month == 2 && !IsLeapYear(year)
        || day == 30 && month == 2 
        || day == 31 && monthNotWith31.contains(month);
    }

    /**
     * Given a year check to see if it is a leap year
     * @param year - integer year
     * 
     * @return Boolean representing whether the year is a leap year
     */
    private static boolean IsLeapYear(int year){
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    /**
     * Given a day, month, and year format the values as a string seperated by slashes
     * @param day - integer day
     * @param month - integer month
     * @param year - integer year
     * 
     * @return String representation of date
     */
    private static String FormatDateAsString(int day, int month, int year){
        return day + "/" + ((month <10) ? "0" + month : month) + "/" + year;
    }


}

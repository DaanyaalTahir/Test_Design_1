package com.ontariotechu.sofe3980U;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{

    private static ArrayList<Integer> monthNotWith31 = new ArrayList<Integer>(Arrays.asList(2, 4, 6, 9, 11));


    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static String GetNextDate(int day, int month, int year){

        if(NotInDomain(day, month, year)){
            return "Invalid Date";
        }

        day++;

        if( day == 29 && month == 2 && IsLeapYear(year) || day == 30 && month != 2 || day == 31 && !monthNotWith31.contains(month) || day < 29){
            return FormatDateAsString(day, month, year);
        }
        
        day = 1;
        month++;
        if(month <=12){
            return FormatDateAsString(day, month, year);
        }

        return FormatDateAsString(day, month-12, year+1);
        
    }

    private static boolean NotInDomain(int day, int month, int year){
        return day < 0 || day > 31 || month < 0 || month > 12 || year > 2212 || year < 1812;
    }

    private static boolean IsLeapYear(int year){
        return year % 4 == 0 || year % 100 != 0 || year % 400 == 0;
    }

    private static String FormatDateAsString(int day, int month, int year){
        return day + "/" + ((month <10) ? "0" + month : month) + "/" + year;
    }


}

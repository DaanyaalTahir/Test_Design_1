package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Parameterized test which takes a csv file as input that tests for various conditions
     * such as leap years, invalid dates, correct dates etc. 
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/test_cases.csv", numLinesToSkip = 1)
    public void testNextDate(int testNumber, int day, int month, int year, String expectedOutput) {
        assertTrue( App.GetNextDate(day, month, year).equals(expectedOutput));
    }

}



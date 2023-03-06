package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @ParameterizedTest
    @CsvFileSource(resources = "./test_cases.csv", numLinesToSkip = 1)
    public void testLetterCountParametrized(int testNumber, int day, int month, int year) {
        assertTrue( App.GetNextDate(day, month, year).equals("6/03/2023"));
    }

}

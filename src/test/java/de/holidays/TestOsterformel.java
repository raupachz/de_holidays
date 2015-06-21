/*
 * The MIT License
 *
 * Copyright 2015 Björn Raupach <raupach@me.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.holidays;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 *
 * @author Björn Raupach <raupach@me.com>
 */
public class TestOsterformel {
    
    @DataProvider
    public Object[][] getYears() {
        return new Object[][] {
            { Year.of(2015), LocalDate.parse("2015-04-05")},
            { Year.of(2016), LocalDate.parse("2016-03-27")},
            { Year.of(2017), LocalDate.parse("2017-04-16")},
            { Year.of(2018), LocalDate.parse("2018-04-01")},
            { Year.of(2019), LocalDate.parse("2019-04-21")},
            { Year.of(2020), LocalDate.parse("2020-04-12")},
            { Year.of(1981), LocalDate.parse("1981-04-19")},
            { Year.of(1954), LocalDate.parse("1954-04-18")}
        };
    }
    
    
    @Test(expectedExceptions = NullPointerException.class)
    public void test_of_null() {
        Osterformel.of(null);
    }
    
    @Test(dataProvider = "getYears")
    public void test_of_year(Year year, LocalDate expected) {
        LocalDate actual = Osterformel.of(year);
        assertEquals(actual, expected);
    }
    
    
}

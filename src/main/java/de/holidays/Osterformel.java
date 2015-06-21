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
import java.util.Objects;

/**
 *
 * @author Björn Raupach <raupach@me.com>
 */
public class Osterformel {
    
    public static LocalDate of(Year year) {
        Objects.requireNonNull(year, "year");
        int X = year.getValue();
        int K = X / 100;
        int M = 15 + (3 * K + 3) / 4 - (8 * K + 13) / 25;
        int S = 2 - (3 * K + 3) / 4;
        int A = X % 19;
        int D = (19 * A + M) % 30;
        int R = (D + A / 11) / 29;
        int OG = 21 + D - R;
        int SZ = 7 - (X + X / 4 + S) % 7;
        int OE = 7 - (OG - SZ) % 7;
        int OS = OG + OE;
        
        return LocalDate.of(X, Month.MARCH, 1).plusDays(OS - 1);
    }
    
}

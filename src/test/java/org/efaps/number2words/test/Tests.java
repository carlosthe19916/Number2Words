/*
 * Copyright 2003 - 2009 The eFaps Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Revision:        $Rev$
 * Last Changed:    $Date$
 * Last Changed By: $Author$
 */

package org.efaps.number2words.test;

import java.util.Locale;

import org.efaps.number2words.Converter;
import org.efaps.number2words.IConverter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Implements the test cases for English and Spanish conversion of numbers to
 * word.
 *
 * @author The eFaps Team
 * @version $Id$
 */
@Test()
public class Tests
{
    /**
     * Test the convert for English language.
     *
     * @param _number   number to check
     * @param _text     expected conversion
     */
    @Test(dataProvider = "english")
    public void english(final int _number,
                        final String _text)
    {
        final IConverter converter = Converter.getConverter(Locale.ENGLISH);
        Assert.assertEquals(converter.convert(_number), _text, "test '" + _number + "'");
    }

    /**
     * Returns the English test data as an array of an array of integer and the
     * related converted text.
     *
     * @return English test data
     */
    @DataProvider(name = "english")
    public Object[][] englishTestData()
    {
        return new Object[][] {
            {0, "zero"},
            {1, "one"},
            {2, "two"},
            {3, "three"},
            {4, "four"},
            {5, "five"},
            {6, "six"},
            {7, "seven"},
            {8, "eight"},
            {16, "sixteen"},
            {100, "one hundred"},
            {118, "one hundred eighteen"},
            {200, "two hundred"},
            {219, "two hundred nineteen"},
            {800, "eight hundred"},
            {801, "eight hundred one"},
            {1316, "one thousand three hundred sixteen"},
            {700000, "seven hundred thousand"},
            {900000, "nine hundred thousand"},
            {1000000, "one million"},
            {2000000, "two million"},
            {3000200, "three million two hundred"},
            {123456789, "one hundred twenty three million four hundred fifty six thousand seven hundred eighty nine"},
            {2147483647, "two billion one hundred forty seven million "
                        + "four hundred eighty three thousand six hundred forty seven"}
        };
    }

    /**
     * Tests the convert for Spanish language.
     *
     * @param _number   number to check
     * @param _text     expected conversion
     */
    @Test(dataProvider = "spanish")
    public void spanish(final int _number,
                        final String _text)
    {
        final IConverter converter = Converter.getConverter(new Locale("es"));
        Assert.assertEquals(converter.convert(_number), _text, "test '" + _number + "'");
    }

    /**
     * Returns the Spanish test data as an array of an array of integer and the
     * related converted text.
     *
     * @return Spanish test data
     */
    @DataProvider(name = "spanish")
    public Object[][] spanishTestData()
    {
        return new Object[][] {
            {0, "cero"},
            {1, "uno"},
            {2, "dos"},
            {3, "tres"},
            {4, "quatro"},
            {5, "cinco"},
            {6, "seis"},
            {7, "siete"},
            {8, "ocho"},
            {16, "diecis\u00E9is"},
            {21, "veintiuno"},
            {22, "veintid\u00F3s"},
            {23, "veintitr\u00E9s"},
            {24, "veinticuatro"},
            {25, "veinticinco"},
            {26, "veintis\u00E9is"},
            {27, "veintisiete"},
            {28, "veintiocho"},
            {29, "veintinueve"},
            {30, "treinta"},
            {100, "cien"},
            {118, "ciento dieciocho"},
            {122, "ciento veintid\u00F3s"},
            {147, "ciento cuarenta y siete"},
            {200, "doscientos"},
            {219, "doscientos diecinueve"},
            {500, "quinientos"},
            {800, "ochocientos"},
            {801, "ochocientos uno"},
            {1316, "un mil trescientos diecis\u00E9is"},
            {24124, "veinticuatro mil ciento veinticuatro"},
            {700000, "sietecientos mil"},
            {900000, "novecientos mil"},
            {1000000, "un mill\u00F3n"},
            {2000000, "dos mill\u00F3nes"},
            {3000200, "tres mill\u00F3nes doscientos"},
            {123456789, "ciento veintitr\u00E9s mill\u00F3nes "
                        + "quatrocientos cincuenta y seis mil "
                        + "sietecientos ochenta y nueve"},
            {1000000000, "un bill\u00F3n"},
            {2147483647, "dos bill\u00F3nes ciento cuarenta y siete mill\u00F3nes "
                        + "quatrocientos ochenta y tres mil "
                        + "seiscientos cuarenta y siete"}
        };
    }
}

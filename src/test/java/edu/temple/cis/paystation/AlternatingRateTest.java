/*
 * Testcases for the Pay Station system.
 *
 * This source code is from the book "Flexible, Reliable Software: Using
 * Patterns and Agile Development" published 2010 by CRC Press. Author: Henrik B
 * Christensen Computer Science Department Aarhus University
 *
 * This source code is provided WITHOUT ANY WARRANTY either expressed or
 * implied. You may study, use, modify, and distribute it for non-commercial
 * purposes. For any commercial use, see http://www.baerbak.com/
 */
package edu.temple.cis.paystation;

import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;


public class AlternatingRateTest {

    PayStation ps;

    @Before
    public void setup() {
        ps = new PayStationImpl();

    }

    /**
     * Entering 5 cents should make the display report 2 minutes parking time when using the linear one rate method.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void AlternatingRateWeekdayGamma() throws IllegalCoinException {
        AlternatingRate ar = new AlternatingRate();
        ar.calculateRate(5, 1, ps); // AlternatingRate sets the correct rate on Paystation object.
        // Expect same behavior as progressive rate.
        // 15 dimes should be 1 hour
        for(int i = 0; i < 15; i++) {
            ps.addPayment(10);
        }

        assertEquals("Should display 60 min for 150 cents", 60, ps.readDisplay());

        // 20 more dimes should be 2 hours
        for(int i = 0; i < 20; i++) {
            ps.addPayment(10);
        }

        assertEquals("Should display 120 min for 160 cents", 120, ps.readDisplay());

    }

    /**
     * Entering 5 cents should make the display report 2 minutes parking time when using the linear one rate method.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void AlternatingRateWeekendGamma() throws IllegalCoinException {
        AlternatingRate ar = new AlternatingRate();
        ar.calculateRate(5, 2, ps); // AlternatingRate sets the correct rate on Paystation object.

        // Expect same behavior as linear one rate.
        for(int i = 0; i < 100; i++) {
            ps.addPayment(10);
        }

        for(int i = 0; i < 40; i++) {
            ps.addPayment(25);
        }

        assertEquals("Should display 800 min for 2000 cents",
                800, ps.readDisplay());

    }

    /**
     * Entering 5 cents should make the display report 2 minutes parking time when using the linear one rate method.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void AlternatingRateWeekdayOmega() throws IllegalCoinException {
        AlternatingRate ar = new AlternatingRate();
        ar.calculateRate(6, 1, ps); // AlternatingRate sets the correct rate on Paystation object.

        // Expect same behavior as linear one rate.
        for(int i = 0; i < 100; i++) {
            ps.addPayment(10);
        }

        for(int i = 0; i < 40; i++) {
            ps.addPayment(25);
        }

        assertEquals("Should display 800 min for 2000 cents",
                800, ps.readDisplay());

    }

    
    /**
     * Entering 5 cents should make the display report 2 minutes parking time when using the linear one rate method.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void AlternatingRateWeekendOmega() throws IllegalCoinException {
        AlternatingRate ar = new AlternatingRate();
        int result = ar.calculateRate(6, 2, ps); // AlternatingRate sets the correct rate on Paystation object.

        // Should be free
        assertEquals("Should display 0 min for 2000 cents",
                0, result);

    }

}

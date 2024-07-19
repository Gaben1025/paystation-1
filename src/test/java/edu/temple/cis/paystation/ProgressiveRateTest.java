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

public class ProgressiveRateTest {

    PayStation ps;

    @Before
    public void setup() {
        ps = new PayStationImpl();
        ProgressiveRate pr = new ProgressiveRate();
        ps.setPayRate(pr);
    }

    /**
     * Entering 5 cents should make the display report 2 minutes parking time when using the progressive rate method.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void ProgressiveRateOneNickel() throws IllegalCoinException {
        ps.addPayment(5);
        assertEquals("Should display 2 min for 5 cents",
                2, ps.readDisplay());
    }

    /**
     * Entering 10 cents should make the display report 4 minutes parking time when using the progressive rate method.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void ProgressiveRateOneDime() throws IllegalCoinException {
        ps.addPayment(10);
        assertEquals("Should display 4 min for 10 cents",
                4, ps.readDisplay());
    }

    /**
     * Entering 0 cents should make the display report 0 minutes parking time when using the progressive rate method.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void ProgressiveRateNoMinutes() throws IllegalCoinException {

        // Explictly don't add any coins

        assertEquals("Should display 0 min for 0 cents",
                0, ps.readDisplay());
    }

    /**
     * Entering 300 cents should make the display report 60 minutes parking time when using the progressive rate method.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void ProgressiveRateHour() throws IllegalCoinException {
        
        // 30 dimes should be 1 hour
        for(int i = 0; i < 15; i++) {
            ps.addPayment(10);
        }

        assertEquals("Should display 60 min for 150 cents", 60, ps.readDisplay());
    }

    /**
     * Entering 310 cents should make the display report 63 minutes parking time when using the progressive rate method.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void ProgressiveRateHourMinute() throws IllegalCoinException {
        
        // 30 dimes should be 1 hour
        for(int i = 0; i < 15; i++) {
            ps.addPayment(10);
        }

        assertEquals("Should display 60 min for 150 cents", 60, ps.readDisplay());

        ps.addPayment(10);

        assertEquals("Should display 63 min for 160 cents", 63, ps.readDisplay());

    }


    /**
     * Entering 350 cents should make the display report 120 minutes parking time when using the progressive rate method.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void ProgressiveRateTwoHours() throws IllegalCoinException {

        
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

}

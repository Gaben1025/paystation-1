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

public class LinearOneRateTest {

    PayStation ps;

    @Before
    public void setup() {
        ps = new PayStationImpl();
        LinearOneRate lor1 = new LinearOneRate();
        ps.setPayRate(lor1);
    }

    /**
     * Entering 5 cents should make the display report 2 minutes parking time when using the linear one rate method.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void LinearOneRateOneNickel() throws IllegalCoinException {
        ps.addPayment(5);
        assertEquals("Should display 2 min for 5 cents",
                2, ps.readDisplay());
    }

    /**
     * Entering 10 cents should make the display report 4 minutes parking time when using the linear one rate method.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void LinearOneRateOneDime() throws IllegalCoinException {
        ps.addPayment(10);
        assertEquals("Should display 4 min for 10 cents",
                4, ps.readDisplay());
    }

    /**
     * Entering 10 cents should make the display report 4 minutes parking time when using the linear one rate method.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void LinearOneRateManyDimes() throws IllegalCoinException {
        for(int i = 0; i < 100; i++) {
            ps.addPayment(10);
        }
        assertEquals("Should display 400 min for 1000 cents",
                400, ps.readDisplay());
    }

    /**
     * Entering 10 cents should make the display report 4 minutes parking time when using the linear one rate method.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void LinearOneRateManyCoins() throws IllegalCoinException {
        for(int i = 0; i < 100; i++) {
            ps.addPayment(10);
        }

        for(int i = 0; i < 40; i++) {
            ps.addPayment(25);
        }

        assertEquals("Should display 800 min for 2000 cents",
                800, ps.readDisplay());
    }


}

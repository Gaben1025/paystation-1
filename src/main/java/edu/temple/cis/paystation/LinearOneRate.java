package edu.temple.cis.paystation;
/**
 * @param coinsInserted numeric for
 */

public class LinearOneRate implements PayRate {

    
    /** 
     * @param coinsInserted
     * @return int
     */
    @Override
    public int calculateRate(int coinsInserted) {
        return (coinsInserted * 2) / 5;
    }
}

package edu.temple.cis.paystation;

public class LinearTwoRate implements PayRate {

    
    /** 
     * @param coinsInserted
     * @return int
     */
    @Override
    public int calculateRate(int coinsInserted) {
        return coinsInserted / 5;
    }
}

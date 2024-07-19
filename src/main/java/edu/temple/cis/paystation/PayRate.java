package edu.temple.cis.paystation;

public interface PayRate
{

    /**
     * This method will properly give PayStation the rate it needs
     */
    public int calculateRate(int coinsInserted);
}

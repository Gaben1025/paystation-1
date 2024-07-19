package edu.temple.cis.paystation;

public class ProgressiveRate implements PayRate {
    /**
     * @param coinsInserted
     * return the amount of time bought using the progresssive rate
     * @return timeBought 
     */

    @Override
    public int calculateRate(int coinsInserted) {
        int timeBought = 0;

        if(coinsInserted < 150 )
        { timeBought = (coinsInserted *2)/5;}
        else if( coinsInserted >= 150 && coinsInserted < 350)
        { timeBought = (((coinsInserted - 150)*3)/10)+60;}
        else if( coinsInserted >= 350)
        { timeBought = ((coinsInserted - 350)/5)+120;}

        return timeBought;
    }
}

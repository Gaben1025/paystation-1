package edu.temple.cis.paystation;

public class AlternatingRate{

    private int rate;
    private int day;
    PayStation Paystation = new PayStationImpl();
    PayRate progressiveRate = new ProgressiveRate();
    PayRate linearOneRate = new LinearOneRate();

    /**
     * rate 5 = Gamma Town
     * rate 6 = Omega Town
     *
     * day 1 = weekday
     * day 2 = weekend
     * @param rate numeric value for rate
     * @param day numeric value for date
     * @param paystation object paystation
     * @return 
     */


    public int calculateRate(int rate,int day,PayStation paystation)
    {
        this.rate = rate;
        this.day = day;
        this.Paystation = paystation;

        //If Weekday
        if (day == 1)
        {
            //Gamma
            if (rate == 5)
            {
                Paystation.setPayRate(progressiveRate);
            }
            //Omega
            else if (rate == 6)
            {
                Paystation.setPayRate(linearOneRate);
            }
        }
        //If Weekend
        else if (day == 2)
        {
            //Gamma
            if (rate == 5)
            {
                Paystation.setPayRate(linearOneRate);
            }
            //Omega
            else if (rate == 6)
            {
                //0 will be regarded as free in main
                return 0;
            }
        }
        return 1;
    }
}

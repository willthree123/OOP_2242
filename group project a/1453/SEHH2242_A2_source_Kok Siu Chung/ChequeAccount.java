public class ChequeAccount extends Account
{
    private double limitPerCheque;
    public ChequeAccount (int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance)//constructor set 10000 as default
    {
        this(theAccountNumber, thePIN, theAvailableBalance, theTotalBalance ,10000 );
    }
    public ChequeAccount (int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance, double limit)//constructor so they can write their own limit per cheque
    {
        super(theAccountNumber, thePIN, theAvailableBalance, theTotalBalance);
        setLimitPerCheque(limit);
    }
    public double getLimitPerCheque() //get the limit per cheque
    {
        return limitPerCheque;
    }
    public void setLimitPerCheque(double limit) // set the limit per cheque
    {
        limitPerCheque = limit;
    }
}
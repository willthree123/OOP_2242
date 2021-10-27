public class SavingAccount extends Account
{
    private double interestRate;
    public SavingAccount (int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance) //constructor that default set to interest rate 0.01
    {
        this(theAccountNumber, thePIN, theAvailableBalance, theTotalBalance, 0.001 );
    }
    public SavingAccount (int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance, double rate) // constructor that can be set to their own number
    {
        super(theAccountNumber, thePIN, theAvailableBalance, theTotalBalance);
        setInterestRate(rate);
    }
    public void setInterestRate(double rate){ //set method to set interest rate
        interestRate = rate;
    }
    public double getInterestRate()//get method to get interest rate
    {
        return interestRate;
    }
}

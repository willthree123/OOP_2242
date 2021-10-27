
/**
 * Write a description of class Transfer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Transfer extends Transaction
{
   private Keypad keypad;
   
   Transfer( int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad)
   {
      // initialize superclass variables
      super( userAccountNumber, atmScreen, atmBankDatabase );
      
      // initialize references to keypad
      keypad = atmKeypad;
   }
   
   @Override
   public void execute(){
        boolean accountAuthenticated = false;  //is the account valid
        boolean amountAuthenticated = false;   //is the amount valid
        BankDatabase bankDatabase = getBankDatabase(); 
        Screen screen = getScreen();
        
        while(accountAuthenticated == false) //when the accountAuthenticated is false that means it is not valid so he need to do it again
        {
            screen.displayMessageLine("Please enter the account number to transfer to");// input the account number that he/she want to transfer to
            screen.displayMessageLine("You can type in 0 to quit this transaction");// input the account number that he/she want to transfer to
            int transferAccount = keypad.getInput();
            if(transferAccount == 0){
                screen.displayMessageLine("This Transaction will be disabled!");
                break;
            }
            else if(transferAccount == getAccountNumber()){
                screen.displayMessageLine("You cannot tranfer money to yourself "); // they cannot tranfer to themselves
            }
            else if(bankDatabase.authenticateTransferUser(transferAccount) == false) // find the transfer account is in the database or not
            {
                screen.displayMessageLine("Account not found, please try again."); // give false answer 
            }
            else
            {
                accountAuthenticated = true;
            }
            while((accountAuthenticated == true) && (amountAuthenticated == false)) // check the amount is valid
            {
            amountAuthenticated = transferMoney(transferAccount,amountAuthenticated);
            }
        }
   }
   
   private boolean transferMoney(int transferAccount , boolean amountAuthenticated){
       do{
            boolean input = true;
            BankDatabase bankDatabase = getBankDatabase(); 
            Screen screen = getScreen();
            if (input == false){ //as the input will not input the second as the cursor may not go the next line, so we add this
                keypad.cursorCannotGoToNextLine();
            }
            screen.displayMessageLine("Please enter the tranfer amount."); // give instruction
            try{
                double transferAmount = keypad.getDoubleInput();
                if (!((transferAmount*10) % 1 == 0)){ //they cannot transfer 0.01 as there are no money IRL that can be represented by 0.01
                    screen.displayMessageLine( "\nIvalid selection. Try again." );
                    break;
                }
                else if (bankDatabase.getAvailableBalance(getAccountNumber()) < transferAmount) // transfer amount is larger than the available balnce, then it cannot transfer
                {
                    screen.displayMessageLine("Not enough balance, please enter amount again");
                    break;
                }
                else
                {
                    amountAuthenticated = true;
                    bankDatabase.debit(getAccountNumber(), transferAmount); //transfer amount
                    bankDatabase.credit(transferAccount, transferAmount);
                    screen.displayMessageLine("Transfer Successful!");
                    break;
                }
            }
            catch(Exception e){ // just incase they type too many decimal places, and it may cause wrong
                input = false;
                screen.displayMessageLine( "\nIvalid selection. Try again." );
            }
       } while(true);
       return amountAuthenticated;
   }
}



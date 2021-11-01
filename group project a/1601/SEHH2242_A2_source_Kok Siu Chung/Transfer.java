
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
            double transferAccount = keypad.getInput();
            if(transferAccount == 0){
                screen.displayMessageLine("This Transaction will be disabled!");
                break;
            }
            else if(transferAccount == getAccountNumber()){
                screen.displayMessageLine("You cannot transfer money to yourself "); // they cannot transfer to themselves
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
   
   private boolean transferMoney(double transferAccount , boolean amountAuthenticated){
       do{
            BankDatabase bankDatabase = getBankDatabase(); 
            Screen screen = getScreen();
            screen.displayMessageLine("Please enter the transfer amount."); // give instruction
            try {
                keypad.cursorCannotGoToNextLine();
                Double transferAmount = keypad.getInput();
                String[] checktransferAmount = transferAmount.toString().split("\\.");
                if (checktransferAmount[1].length() > 2 || transferAmount < 0) { //support two decimal places

                    screen.displayMessageLine("\nInvalid amount. Try again.(must be two decimal places)");
                    break;
                } else if (transferAmount == 0) {
                    screen.displayMessageLine("\nYou cannot type 0 as there will be nothing change");
                    break;
                } else if (bankDatabase.getAvailableBalance(getAccountNumber()) <= transferAmount) // transfer amount is larger than the available balnce, then it cannot transfer
                {
                    screen.displayMessageLine("Not enough balance, please enter amount again");
                    break;
                } else {
                    amountAuthenticated = true;
                    bankDatabase.debit(getAccountNumber(), transferAmount); //transfer amount
                    bankDatabase.credit(transferAccount, transferAmount);
                    screen.displayMessageLine("Transfer Successful!");
                    break;
                }

            }
            catch(Exception e){// just incase they type too many decimal places, and it may cause wrong
                screen.displayMessageLine( "\nInvalid input. Try again." );
            }
       } while(true);
       return amountAuthenticated;
   }
}



// Withdrawal.java
// Represents a withdrawal ATM transaction

public class Withdrawal extends Transaction
{
   private double amount; // amount to withdraw
   private Keypad keypad; // reference to keypad
   private CashDispenser cashDispenser; // reference to cash dispenser

   // constant corresponding to menu option to cancel
   private final static int CANCELED = 5;

   // Withdrawal constructor
   public Withdrawal( int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad, 
      CashDispenser atmCashDispenser )
   {
      // initialize superclass variables
      super( userAccountNumber, atmScreen, atmBankDatabase );
      
      // initialize references to keypad and cash dispenser
      keypad = atmKeypad;
      cashDispenser = atmCashDispenser;
   } // end Withdrawal constructor

   // perform transaction
   public void execute()
   {
      boolean cashDispensed = false; // cash was not dispensed yet
      double availableBalance; // amount available for withdrawal

      // get references to bank database and screen
      BankDatabase bankDatabase = getBankDatabase(); 
      Screen screen = getScreen();

      // loop until cash is dispensed or the user cancels
      do
      {
         // obtain a chosen withdrawal amount from the user 
         amount = displayMenuOfAmounts();
         
         // check whether user chose a withdrawal amount or canceled
         if ( amount != CANCELED )
         {
            // get available balance of account involved
            availableBalance = 
               bankDatabase.getAvailableBalance( getAccountNumber() );
      
            // check whether the user has enough money in the account 
            if ( amount <= availableBalance )
            {   
               // check whether the cash dispenser has enough money
               if ( cashDispenser.isSufficientCashAvailable( amount ) )
               {
                  // update the account involved to reflect withdrawal
                  bankDatabase.debit( getAccountNumber(), amount );
                  
                  cashDispenser.dispenseCash( amount ); // dispense cash
                  cashDispensed = true; // cash was dispensed

                  // instruct user to take cash
                  screen.displayMessageLine( 
                     "\nPlease take your cash now." );
               } // end if
               else // cash dispenser does not have enough cash
                  screen.displayMessageLine(
                     "\nInsufficient cash available in the ATM." +
                     "\n\nPlease choose a smaller amount." );
            } // end if
            else // not enough money available in user's account
            {
               screen.displayMessageLine( 
                  "\nInsufficient funds in your account." +
                  "\n\nPlease choose a smaller amount." );
            } // end else
         } // end if
         else // user chose cancel menu option 
         {
            screen.displayMessageLine( "\nCanceling transaction..." );
            return; // return to main menu because user canceled
         } // end else
      } while ( !cashDispensed );

   } // end method execute

   // display a menu of withdrawal amounts and the option to cancel;
   // return the chosen amount or 0 if the user chooses to cancel
   private double displayMenuOfAmounts()
   {
      double userChoice = 0; // local variable to store return value

      Screen screen = getScreen(); // get screen reference
      
      // array of amounts to correspond to menu numbers
      int amounts[] = { 0, 100, 500, 1000 };

      // loop while no valid choice has been made
      while ( userChoice == 0 )
      {
         // display the menu
         screen.displayMessageLine( "\nWithdrawal Menu:" );
         screen.displayMessageLine( "1 - Withdrawal $100" );
         screen.displayMessageLine( "2 - Withdrawal $500" );
         screen.displayMessageLine( "3 - Withdrawal $1000" );
         screen.displayMessageLine( "4 - Type in yourself" );
         screen.displayMessageLine( "5 - Cancel transaction" );
         screen.displayMessage( "\nChoose a withdrawal amount: " );

         double input = keypad.getInput(); // get user input through keypad

         // determine how to proceed based on the input value
         switch ((int) input)
         {
            case 1: // if the user chose a withdrawal amount
            case 2: // (i.e., chose option 1, 2, 3, 4 or 5), return the
            case 3: // corresponding amount from amounts array
               userChoice = amounts[(int) input]; // save user's choice
               break;
            case 4: userChoice = checkUserInput();
                break;
            case CANCELED: // the user chose to cancel
               userChoice = CANCELED; // save user's choice
               break;
            default: // the user did not enter a value from 1-6
               screen.displayMessageLine(
                  "\nInvalid selection. Try again." );
         } // end switch
      } // end while

      return userChoice; // return withdrawal amount or CANCELED
   } // end method displayMenuOfAmounts
   
   private double checkUserInput(){ // alongside of the preset amount they can type in their amount, it creates flexibility
      double input = 0;
      do{
          if (input == -1){ // the next line cause cursor error and cannot read next line
              keypad.cursorCannotGoToNextLine();
          }
          Screen screen = getScreen();
          screen.displayMessageLine( "\n\nPlease type in your withdrawal amount" );
          screen.displayMessageLine( "You need to input an amount that can be divided by 100" ); // give instructions
          screen.displayMessageLine( "Or you can type in 5 to cancel this withdrawal transaction" );
          try{
              input = keypad.getInput();
              if (input == 5){
              return input;
              }
              else if (input == 0){
                  screen.displayMessageLine( "\nInvalid selection. Try again." );
                  screen.displayMessageLine( "\nYou cannot type 0 as you will not be able to withdrawal any money" );
              }
              else if (!(input % 100 == 0)){ //cannot output amount that it mod 100 is not 0
                  screen.displayMessageLine( "\nInvalid selection. Try again." );
                  screen.displayMessageLine( "You need to enter the amount that can be divided by 100" );
              }
              else {
                  return input;   
              }
          }
          catch(Exception e){ // just in case they type in floating point it will not stop the program
              input = -1;
              screen.displayMessageLine( "\nInvalid selection. Try again." );
              screen.displayMessageLine( "You need to enter the amount that is an integer that can be divided by 100" );
          }
      } while(true);
   }    
} // end class Withdrawal



/**************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
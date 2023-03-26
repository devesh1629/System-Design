package DesignATM.ATMStates;

import DesignATM.ATM;
import DesignATM.Card;

public class CheckBalanceState extends ATMState {

    public CheckBalanceState() {
    }
    @Override
    public void displayBalance(ATM atm, Card card) {
        System.out.print("Your balance is: " + card.getBankBalance());
        ATMState.exit(atm);
    }
}

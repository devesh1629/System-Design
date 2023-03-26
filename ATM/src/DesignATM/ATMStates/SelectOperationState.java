package DesignATM.ATMStates;

import DesignATM.ATM;
import DesignATM.Card;
import DesignATM.TransactionType;

public class SelectOperationState extends ATMState {
    public SelectOperationState() {
        showOperations();
    }
    @Override
    public void selectOperation(ATM atm, Card card, TransactionType transactionType) {
        // enhanced version of Switch case, in Java version 17 and above only
        switch (transactionType) {
            case CASH_WITHDRAWAL -> atm.setCurrentATMState(new CashWithdrawalState());
            case BALANCE_CHECK -> atm.setCurrentATMState(new CheckBalanceState());
            default -> {
                System.out.println("Invalid Option");
                ATMState.exit(atm);
            }
        }
    }
    public void showOperations() {
        System.out.println("Please select one of the  following operation");
        TransactionType.showAllTransactionTypes();
    }
}

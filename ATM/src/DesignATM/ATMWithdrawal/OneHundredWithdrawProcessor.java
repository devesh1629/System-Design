package DesignATM.ATMWithdrawal;

import DesignATM.ATM;

public class OneHundredWithdrawProcessor extends FiveHundredWithdrawProcessor {

    public OneHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount) {
        int required = remainingAmount / 100;
        int balance = remainingAmount % 100;

        if(required <= atm.getNoOfOneHundredNotes()) {
            atm.deductOneHundredNotes(required);
        }
        else {
            atm.deductOneHundredNotes(atm.getNoOfOneHundredNotes());
            balance = balance + (required + atm.getNoOfOneHundredNotes()) * 100;
        }
        if(balance != 0) {
            super.withdraw(atm, balance);
        }
    }
}

package DesignATM.ATMWithdrawal;

import DesignATM.ATM;

public class FiveHundredWithdrawProcessor extends TwoThousandWithdrawProcessor {

    public FiveHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    public void withdraw(ATM atm, int remainingAmount) {
        int required = remainingAmount / 500;
        int balance = remainingAmount % 500;

        if(required <= atm.getNoOfFiveHundredNotes()) {
            atm.deductFiveHundredNotes(required);
        }
        else {
            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
            balance = balance + (required + atm.getNoOfFiveHundredNotes()) * 500;
        }
        if(balance != 0) {
            super.withdraw(atm, balance);
        }
    }
}

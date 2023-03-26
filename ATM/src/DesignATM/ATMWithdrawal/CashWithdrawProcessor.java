package DesignATM.ATMWithdrawal;

import DesignATM.ATM;

public class CashWithdrawProcessor {
    CashWithdrawProcessor nextCashWithdrawalProcessor;
    public CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
        this.nextCashWithdrawalProcessor = cashWithdrawProcessor;
    }
    public void withdraw(ATM atm, int remainingAmount) {
        if(nextCashWithdrawalProcessor != null) {
            nextCashWithdrawalProcessor.withdraw(atm, remainingAmount);
        }
    }
}

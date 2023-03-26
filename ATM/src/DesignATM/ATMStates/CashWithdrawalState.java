package DesignATM.ATMStates;

import DesignATM.ATM;
import DesignATM.ATMWithdrawal.CashWithdrawProcessor;
import DesignATM.ATMWithdrawal.FiveHundredWithdrawProcessor;
import DesignATM.ATMWithdrawal.OneHundredWithdrawProcessor;
import DesignATM.ATMWithdrawal.TwoThousandWithdrawProcessor;
import DesignATM.Card;

public class CashWithdrawalState extends ATMState {

    public CashWithdrawalState() {
        System.out.println("Please enter cash withdrawal amount");
    }

    public void cashWithdrawal(ATM atm, Card card, int withdrawAmount) {
        if(atm.getAtmBalance() < withdrawAmount) {
            System.out.println("Insufficient fund in ATM machine");
            ATMState.exit(atm);
        }
        else if(card.getBankBalance() < withdrawAmount) {
            System.out.println("Insufficient fund in bank account");
            ATMState.exit(atm);
        }
        else {
            card.deductBankBalance(withdrawAmount);
            atm.deductATMBalance(withdrawAmount);

            // using chain of responsibility for this logic, how many 2k Rs notes, how many 500 Rs
            // notes has to be withdrawal
            CashWithdrawProcessor withDrawProcessor = new TwoThousandWithdrawProcessor(new
                        FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));
            withDrawProcessor.withdraw(atm, withdrawAmount);
            ATMState.exit(atm);
        }
    }
}

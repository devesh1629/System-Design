package DesignATM.ATMStates;

import DesignATM.ATM;
import DesignATM.Card;
public class HasCardState extends ATMState {

    public HasCardState() {
    }
    @Override
    public void authenticatePIN(ATM atm, Card card, int pin) {
        if(!card.isCorrectPINEntered(pin)) {
            System.out.print("Incorrect pin");
            ATMState.exit(atm);
        }
        else {
            atm.setCurrentATMState(new SelectOperationState());
        }
    }
}

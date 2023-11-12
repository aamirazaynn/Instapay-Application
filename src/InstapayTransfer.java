import paymentProviders.BankProvider;
import paymentProviders.CIBProvider;
import paymentProviders.NationalBankOfEgyptProvider;

import java.util.Objects;

public class InstapayTransfer implements Transaction {
    public void transfer(float amount, String toUser, String toProvider, ApplicationData applicationData) {
        String phoneNum = applicationData.getPhoneNumByUsername(toUser);
        String type = applicationData.getUserType(toUser);
        if(Objects.equals(type, "BANK")) {
            BankProvider b;
            if(Objects.equals(toProvider, "CIB")){
                b = new CIBProvider();
            } else{
                b = new NationalBankOfEgyptProvider();
            }
            b.deposit(phoneNum, amount);
        }
    }
}
import paymentProviders.BankProvider;
import paymentProviders.CIBProvider;
import paymentProviders.NationalBankOfEgyptProvider;

import java.util.Objects;

public class BankTransaction implements Transaction{

    public void transfer(float amount, String toUser, String toProvider, ApplicationData applicationData) {
        BankProvider b;
        if(Objects.equals(toProvider, "CIB")){
            b = new CIBProvider();
        } else{
            b = new NationalBankOfEgyptProvider();
        }
        b.deposit(toUser, amount);
    }
}

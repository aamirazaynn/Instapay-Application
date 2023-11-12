import paymentProviders.BankProvider;
import paymentProviders.CIBProvider;
import paymentProviders.NationalBankOfEgyptProvider;

import java.util.Objects;

public class BankTransaction implements Transaction{

    public boolean transfer(float amount, String toUser, String toProvider, ApplicationData applicationData) {
        BankProvider b;
        if(Objects.equals(toProvider, "CIB")){
            b = new CIBProvider();
        } else{
            b = new NationalBankOfEgyptProvider();
        }
        if(b.isExist(toProvider)){
            b.deposit(toUser, amount);
            return true;
        }
        return false;
    }
}

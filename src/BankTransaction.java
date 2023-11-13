//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Objects;
import paymentProviders.BankProvider;
import paymentProviders.CIBProvider;
import paymentProviders.NationalBankOfEgyptProvider;

public class BankTransaction implements Transaction {
    public BankTransaction() {
    }

    public boolean transfer(float amount, String toUser, String toProvider, ApplicationData applicationData) {
        Object b;
        if (Objects.equals(toProvider, "CIB")) {
            b = new CIBProvider();
        } else {
            b = new NationalBankOfEgyptProvider();
        }

        if (((BankProvider)b).isExist(toProvider)) {
            ((BankProvider)b).deposit(toUser, amount);
            return true;
        } else {
            return false;
        }
    }
}

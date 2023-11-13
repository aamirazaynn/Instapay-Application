//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Objects;
import paymentProviders.BankProvider;
import paymentProviders.CIBProvider;
import paymentProviders.NationalBankOfEgyptProvider;
import paymentProviders.VodafoneProvider;
import paymentProviders.WalletProvider;

public class InstapayTransaction implements Transaction {
    public InstapayTransaction() {
    }

    public boolean transfer(float amount, String toUser, String toProvider, ApplicationData applicationData) {
        String phoneNum = applicationData.getPhoneNumByUsername(toUser);
        String type = applicationData.getUserType(toUser);
        toProvider = applicationData.getUser(toUser).getProvider().toString();
        if (Objects.equals(type, "BANK")) {
            Object b;
            if (Objects.equals(toProvider, "CIB")) {
                b = new CIBProvider();
            } else {
                b = new NationalBankOfEgyptProvider();
            }

            if (((BankProvider)b).isExist(toProvider)) {
                ((BankProvider)b).deposit(phoneNum, amount);
                return true;
            } else {
                return false;
            }
        } else {
            WalletProvider w = new VodafoneProvider();
            if (w.matchPhoneNum(phoneNum)) {
                w.deposit(phoneNum, amount);
                return true;
            } else {
                return false;
            }
        }
    }
}

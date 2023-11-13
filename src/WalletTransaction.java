//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import paymentProviders.VodafoneProvider;
import paymentProviders.WalletProvider;

public class WalletTransaction implements Transaction {
    public WalletTransaction() {
    }

    public boolean transfer(float amount, String toUser, String toProvider, ApplicationData applicationData) {
        WalletProvider w = new VodafoneProvider();
        if (w.matchPhoneNum(toUser)) {
            w.deposit(toUser, amount);
            return true;
        } else {
            return false;
        }
    }
}

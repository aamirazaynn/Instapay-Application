//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import paymentProviders.ProviderInterface;
import paymentProviders.VodafoneProvider;
import paymentProviders.WalletProvider;

public class WalletTransaction implements Transaction {
    public WalletTransaction() {
    }

    public boolean transfer(float amount, String toUser, ProviderInterface toProvider, ApplicationData applicationData) {
        if (((WalletProvider)toProvider).matchPhoneNum(toUser)) {
            toProvider.deposit(toUser, amount);
            return true;
        } else {
            return false;
        }
    }
}

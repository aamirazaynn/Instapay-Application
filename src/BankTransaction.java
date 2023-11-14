import paymentProviders.BankProvider;
import paymentProviders.ProviderInterface;

public class BankTransaction implements Transaction {
    public BankTransaction() {
    }

    public boolean transfer(float amount, String toUser, ProviderInterface toProvider, ApplicationData applicationData) {
        if (((BankProvider)toProvider).isExist(toUser)) {
            toProvider.deposit(toUser, amount);
            return true;
        } else {
            return false;
        }
    }
}
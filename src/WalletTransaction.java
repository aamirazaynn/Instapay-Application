import paymentProviders.*;

public class WalletTransaction implements Transaction{
    public void transfer(float amount, String toUser, String toProvider, ApplicationData applicationData) {
        WalletProvider w = new VodafoneProvider();
        w.deposit(toUser, amount);
    }
}

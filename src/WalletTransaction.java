import paymentProviders.*;

public class WalletTransaction implements Transaction{
    public boolean transfer(float amount, String toUser, String toProvider, ApplicationData applicationData) {
        WalletProvider w = new VodafoneProvider();
        if(w.matchPhoneNum(toUser)){
            w.deposit(toUser, amount);
            return true;
        } else{
            return false;
        }

    }
}

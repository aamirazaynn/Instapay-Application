import paymentProviders.*;

public class InstapayTransaction implements Transaction {
    public InstapayTransaction() {}

    public boolean transfer(float amount, String toUser, ProviderInterface toProvider, ApplicationData applicationData) {
        if(applicationData.isUserExist(toUser)) {
            String phone = applicationData.getPhoneNumByUsername(toUser);
            toProvider.deposit(phone, amount);
            return true;
        }
        return false;
    }
}

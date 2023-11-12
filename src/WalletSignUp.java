import paymentProviders.VodafoneProvider;
import paymentProviders.WalletProvider;

public class WalletSignUp extends SignUp {

    public void register(ApplicationData applicationData, String providerName) {
        User user=new User();
        SignUpValidation s = new SignUpValidation();
        WalletProvider walletProvider = new VodafoneProvider();
        if (!s.checkExistUserName(super.getUserName()) && s.checkStrongPassword(super.getPassword()) && walletProvider.matchPhoneNum(super.getPhoneNumber())) {
            user.setUserInfo(new UserInfo(super.getUserName(), super.getPassword()));
            user.setPhoneNumber(super.getPhoneNumber());
            user.setProvider(super.getProviderName());
            user.setUsertype("WALLET");
            applicationData.addUser(user);
        } else {
            System.out.println("Fail");
        }
    }
}

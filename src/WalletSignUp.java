//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import paymentProviders.ProviderInterface;
import paymentProviders.WalletProvider;

public class WalletSignUp extends SignUp {
    public WalletSignUp() {
    }

    public void register(ApplicationData applicationData, ProviderInterface walletProvider) {
        User user = new User();
        SignUpValidation s = new SignUpValidation();
        if (!s.checkExistUserName(super.getUserName(), applicationData)) {
            if (s.checkStrongPassword(super.getPassword())) {
                if (((WalletProvider)walletProvider).matchPhoneNum(super.getPhoneNumber())) {
                    user.setUsername(super.getUserName());
                    user.setPassword(super.getPassword());
                    user.setPhoneNumber(super.getPhoneNumber());
                    user.setProvider(super.getProviderName());
                    user.setBalance(((WalletProvider)walletProvider).getBalanceByPhoneNumber(super.getPhoneNumber()));
                    user.setUsertype("WALLET");
                    applicationData.addUser(user);
                } else {
                    System.out.println("Phone number is not exist");
                }
            } else {
                System.out.println("Password is not strong");
            }
        } else {
            System.out.println("user Exist");
        }

    }
}

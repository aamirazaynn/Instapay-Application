//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import paymentProviders.WalletProvider;

public class WalletSignUp extends SignUp {
    public WalletSignUp() {
    }

    public void register(ApplicationData applicationData, WalletProvider walletProvider) {
        User user = new User();
        SignUpValidation s = new SignUpValidation();
        if (!s.checkExistUserName(super.getUserName(), applicationData)) {
            if (s.checkStrongPassword(super.getPassword())) {
                if (walletProvider.matchPhoneNum(super.getPhoneNumber())) {
                    user.setUsername(super.getUserName());
                    user.setPassword(super.getPassword());
                    user.setPhoneNumber(super.getPhoneNumber());
                    user.setProvider(super.getProviderName());
                    user.setBalance(walletProvider.getBalanceByPhoneNumber(super.getPhoneNumber()));
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

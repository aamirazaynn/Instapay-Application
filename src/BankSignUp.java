//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import paymentProviders.BankProvider;

public class BankSignUp extends SignUp {
    private String cardNumber;

    public BankSignUp() {
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void register(ApplicationData applicationData, BankProvider bankProvider) {
        User user = new User();
        SignUpValidation s = new SignUpValidation();
        if (!s.checkExistUserName(super.getUserName(), applicationData)) {
            if (s.checkStrongPassword(super.getPassword())) {
                if (bankProvider.matchData(this.cardNumber, super.getPhoneNumber())) {
                    user.setUsername(super.getUserName());
                    user.setPassword(super.getPassword());
                    user.setPhoneNumber(super.getPhoneNumber());
                    user.setProvider(super.getProviderName());
                    user.setBalance(bankProvider.getBalanceByCardNum(cardNumber));
                    user.setUsertype("BANK");
                    applicationData.addUser(user);
                } else {
                    System.out.println("Wrong card number or phone number");
                }
            } else {
                System.out.println("Weak password");
            }
        } else {
            System.out.println("username already exist");
        }

    }
}

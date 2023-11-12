import paymentProviders.BankProvider;
import paymentProviders.CIBProvider;
import paymentProviders.NationalBankOfEgyptProvider;

public class BankSignUp extends SignUp {
    String cardNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void register(LocalStorage localStorage, String providerName) {
        User user=new User();
        SignUpValidation s = new SignUpValidation();
        BankProvider p;

        if (providerName.equalsIgnoreCase("NATIONALBANKOFEGYPT")) {
            p = new NationalBankOfEgyptProvider();
        } else {
            p = new CIBProvider();
        }

        if (!s.checkExistUserName(super.getUserName()) && s.checkStrongPassword(super.getPassword())&& p.matchData(cardNumber, super.getPhoneNumber())) {
            user.setUserInfo(new UserInfo(super.getUserName(), super.getPassword()));
            user.setPhoneNumber(super.getPhoneNumber());
            user.setProvider(super.getProviderName());
            user.setUsertype("BANK");
            localStorage.addUser(user);
        } else {
            System.out.println("Fail");
        }
    }
}
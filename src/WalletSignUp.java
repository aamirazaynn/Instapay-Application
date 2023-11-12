public class WalletSignUp extends SignUp {

    @Override
    public void register(LocalStorage localStorage, String providerName) {
        User user=new User();
        SignUpValidation s = new SignUpValidation();
        if (!s.checkExistUserName(super.getUserName()) && s.checkStrongPassword(super.getPassword())) {
            user.setUserInfo(new UserInfo(super.getUserName(), super.getPassword()));
            user.setPhoneNumber(super.getPhoneNumber());
            user.setBalance();
            user.setProvider(new Provider());
            localStorage.addUser(user);
            System.out.println("Success");
        } else {
            System.out.println("Fail");
        }
    }
}

public class User {
    private UserInfo userInfo;
    private float balance ;
    private String phoneNumber;
    private Provider provider;
    private Usertype usertype;

    public User(UserInfo userInfo, float balance, String phoneNumber, Provider provider) {
        this.userInfo = userInfo;
        this.balance = balance;
        this.phoneNumber = phoneNumber;
        this.provider = provider;
    }
    public User() {

    }
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Provider getProvider() {
        return provider;
    }

    public Usertype getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        if (usertype.equalsIgnoreCase("WALLET")) {
            this.usertype = Usertype.WALLET;
        } else if (usertype.equalsIgnoreCase("BANK")) {
            this.usertype = Usertype.BANK;
        }
    }

    public void setProvider(String provider) {
        if (provider.equalsIgnoreCase("NATIONALBANKOFEGYPT")) {
            this.provider = Provider.NATIONALBANKOFEGYPT;
        } else if (provider.equalsIgnoreCase("CIB")) {
            this.provider = Provider.CIB;
        } else if (provider.equalsIgnoreCase("VODAFONE")) {
            this.provider = Provider.VODAFONE;
        } else if (provider.equalsIgnoreCase("FAWRY")) {
            this.provider = Provider.FAWRY;
        }
    }
}

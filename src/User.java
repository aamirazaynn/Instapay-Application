//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class User {
    private String username;
    private String password;
    private float balance;
    private String phoneNumber;
    private Provider provider;
    private Usertype usertype;

    public User(String username, String password, float balance, String phoneNumber, String provider, String usertype) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.phoneNumber = phoneNumber;
        this.setProvider(provider);
        this.setUsertype(usertype);
    }

    public User() {
    }

    public float getBalance() {
        return this.balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Provider getProvider() {
        return this.provider;
    }

    public Usertype getUsertype() {
        return this.usertype;
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

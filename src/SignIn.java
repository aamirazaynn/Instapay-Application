//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Objects;

public class SignIn {
    String userName;
    String password;

    public SignIn() {
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean confirmSignIn(ApplicationData applicationData) {
        if (!Objects.equals(applicationData.getPassByUserName(this.userName), this.password)) {
            System.out.println("Wrong password or username");
            return false;
        } else {
            return true;
        }
    }
}

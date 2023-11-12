import java.util.Objects;

public class SignIn {

    String userName;
    String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void confirmSignIn(ApplicationData applicationData) {
        if(!Objects.equals(applicationData.getPassByUserName(userName), password)){
            System.out.println("Fail to signin");
        }
    }
}

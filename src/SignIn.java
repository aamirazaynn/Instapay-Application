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

    public boolean confirmSignIn(ApplicationData applicationData) {
        if (true) {
            String storedPassword = applicationData.getPassByUserName(userName);

            if (storedPassword != null && storedPassword.equals(password)) {
                System.out.println("Sign in successful");
                return true;
            } else {
                System.out.println("Invalid username or password");
                return false;
            }
        }
        else {
            System.out.println("Invalid username or password format");
            return false;
        }
    }
}

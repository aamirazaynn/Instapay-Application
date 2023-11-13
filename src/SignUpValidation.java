//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.regex.Pattern;

public class SignUpValidation {
    public SignUpValidation() {
    }

    public boolean checkExistUserName(String userName, ApplicationData applicationData) {
        return applicationData.isUserExist(userName);
    }

    public boolean checkStrongPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(password).matches();
    }
}

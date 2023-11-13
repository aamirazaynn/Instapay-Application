//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransactionValidations {
    public TransactionValidations() {
    }

    public static boolean isValidCardNumber(String cardNumber) {
        String cleanCardNumber = cardNumber.replaceAll("\\D", "");
        String regex = "^[0-9]{16}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cleanCardNumber);
        return matcher.matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^01[0-9]{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}

package paymentProviders;

import java.util.Map;

public interface ProviderInterface {
    void withdrawing(String var1, float var2);

    void deposit(String var1, float var2);

    void printUsers();

    Map<String, String> createUserMap(String cardNum, String phoneNum, String balance);
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package paymentProviders;

public interface WalletProvider {
    float getBalanceByPhoneNumber(String var1);

    boolean matchPhoneNum(String var1);

    void withdrawing(String var1, float var2);

    void deposit(String var1, float var2);

    void printUsers();
}

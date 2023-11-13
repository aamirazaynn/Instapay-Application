//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package paymentProviders;

public interface BankProvider {
    float getBalanceByCardNum(String var1);

    boolean matchData(String var1, String var2);

    void withdrawing(String var1, float var2);

    void deposit(String var1, float var2);

    boolean isExist(String var1);

    void printUsers();
}

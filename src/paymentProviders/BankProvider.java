package paymentProviders;
public interface BankProvider extends ProviderInterface{
    float getBalanceByCardNum(String var1);
    boolean matchData(String var1, String var2);
    boolean isExist(String var1);

}

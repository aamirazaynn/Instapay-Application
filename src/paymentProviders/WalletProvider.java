package paymentProviders;

public interface WalletProvider extends ProviderInterface{
    float getBalanceByPhoneNumber(String var1);
    boolean matchPhoneNum(String var1);
}

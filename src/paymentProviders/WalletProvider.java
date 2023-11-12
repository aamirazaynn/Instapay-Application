public interface WalletProvider{
    public float getBalanceByPhoneNumber(String phone);
    public boolean matchPhoneNum(String phone);
    public void withdrawing(String cn, float amount);
    public void deposit(String cn, float amount);
}

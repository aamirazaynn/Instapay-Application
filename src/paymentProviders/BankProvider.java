public interface BankProvider {
    public float getBalanceByCardNum(String cardNum);
    public boolean matchData(String cardNum, String phone);
    public void withdrawing(String cn, float amount);
    public void deposit(String cn, float amount);
}

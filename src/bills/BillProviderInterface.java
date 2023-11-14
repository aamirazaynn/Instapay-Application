package bills;

public interface BillProviderInterface {
    public float getAmountByCode(String code) ;

    public void payBill(String code);

    public void seed();
}

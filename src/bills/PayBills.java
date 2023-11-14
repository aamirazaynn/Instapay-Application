package bills;

public class PayBills {
    public void pay(String code, BillProviderInterface billProviderInterface){
        billProviderInterface.payBill(code);
    }
    public float getAmountByCode(String code, BillProviderInterface billProviderInterface){
        return billProviderInterface.getAmountByCode(code);
    }
}

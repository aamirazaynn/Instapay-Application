import java.util.ArrayList;
import java.util.Map;

public interface PayBills{
    public boolean pay(String code ,float balance );
}
class GasBill implements PayBills {
    public boolean pay(String code, float balance) {
        GasBillProvider g = new GasBillProvider();
        if(g.getAmountByCode(code) > balance){
            g.payBill(code);
            return true;

        } else{
            return false;
        }
    }
}
class WaterBill implements PayBills {
    public boolean pay(String code, float balance) {
        WaterBillProvider w = new WaterBillProvider();
        if(w.getAmountByCode(code) > balance){
            w.payBill(code);
            return true;

        } else{
            return false;
        }
    }
}
class ElectricityBill implements PayBills {
    public boolean pay(String code, float balance) {
        ElectricityBillProvider e = new ElectricityBillProvider();
        if(e.getAmountByCode(code) > balance){
            e.payBill(code);
            return true;

        } else{
            return false;
        }
    }
}



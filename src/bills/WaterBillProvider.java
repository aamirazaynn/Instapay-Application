package bills;

import java.util.HashMap;
import java.util.Map;

public class WaterBillProvider implements BillProviderInterface{
    private Map<String, Float> map = new HashMap<>();

    public WaterBillProvider() {
        seed();
    }

    public float getAmountByCode(String code) {
        Float amount = this.map.get(code);
        if(amount != null) {
            return amount.floatValue();
        }
        else{
            return 0.0F;
        }
    }

    public void payBill(String code) {
        this.map.remove(code);
    }

    public void seed() {
        this.map.put("2023", 900.0F);
        this.map.put("2022", 910.0F);
        this.map.put("2021", 920.0F);
        this.map.put("2020", 930.0F);
    }
    public void print() {
        System.out.println(this.map);
    }
}

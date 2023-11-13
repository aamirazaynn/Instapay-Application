//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package bills;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class ElectricityBillProvider {
    private ArrayList<Map<String, String>> vector = new ArrayList();

    ElectricityBillProvider() {
    }

    public float getAmountByCode(String code) {
        Iterator var2 = this.vector.iterator();

        Map item;
        do {
            if (!var2.hasNext()) {
                return 0.0F;
            }

            item = (Map)var2.next();
        } while(!((String)item.get("code")).equals(code));

        return Float.parseFloat((String)item.get("amount"));
    }

    public void payBill(String code) {
        Iterator var2 = this.vector.iterator();

        while(var2.hasNext()) {
            Map<String, String> item = (Map)var2.next();
            this.vector.removeIf((Item) -> {
                return ((String)item.get("code")).equals(code);
            });
        }

    }

    public void seed() {
        this.vector.add(Map.of("code", "12345", "amount", "100"));
        this.vector.add(Map.of("code", "67891", "amount", "200"));
        this.vector.add(Map.of("code", "11121", "amount", "300"));
        this.vector.add(Map.of("code", "31415", "amount", "400"));
    }
}

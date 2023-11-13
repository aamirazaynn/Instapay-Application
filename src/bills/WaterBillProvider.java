//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package bills;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class WaterBillProvider {
    private ArrayList<Map<String, String>> vector = new ArrayList();

    WaterBillProvider() {
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
        this.vector.add(Map.of("code", "2023", "amount", "900"));
        this.vector.add(Map.of("code", "2022", "amount", "910"));
        this.vector.add(Map.of("code", "2021", "amount", "920"));
        this.vector.add(Map.of("code", "2020", "amount", "930"));
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package bills;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class GasBillProvider {
    private ArrayList<Map<String, String>> vector = new ArrayList();

    GasBillProvider() {
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
        this.vector.add(Map.of("code", "2001", "amount", "500"));
        this.vector.add(Map.of("code", "2002", "amount", "600"));
        this.vector.add(Map.of("code", "2003", "amount", "700"));
        this.vector.add(Map.of("code", "2004", "amount", "800"));
    }
}

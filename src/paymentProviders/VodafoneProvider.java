//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package paymentProviders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class VodafoneProvider implements WalletProvider {
    private ArrayList<Map<String, String>> vector = new ArrayList();

    public VodafoneProvider() {
        this.seed();
    }

    public float getBalanceByPhoneNumber(String phone) {
        Iterator var2 = this.vector.iterator();

        Map map;
        do {
            if (!var2.hasNext()) {
                return 0.0F;
            }

            map = (Map)var2.next();
        } while(!Objects.equals(map.get("phoneNum"), phone));

        return Float.parseFloat((String)map.get("balance"));
    }

    public boolean matchPhoneNum(String phone) {
        Iterator var2 = this.vector.iterator();

        Map map;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            map = (Map)var2.next();
        } while(!Objects.equals(map.get("phoneNum"), phone));

        return true;
    }

    public void withdrawing(String cn, float amount) {
        Iterator var3 = this.vector.iterator();

        while(var3.hasNext()) {
            Map<String, String> map = (Map)var3.next();
            if (Objects.equals(map.get("phoneNum"), cn)) {
                float balance = Float.parseFloat((String)map.get("balance"));
                balance -= amount;
                map.put("balance", String.valueOf(balance));
            }
        }

    }

    public void deposit(String cn, float amount) {
        Iterator var3 = this.vector.iterator();

        while(var3.hasNext()) {
            Map<String, String> map = (Map)var3.next();
            if (Objects.equals(map.get("phoneNum"), cn)) {
                float balance = Float.parseFloat((String)map.get("balance"));
                balance += amount;
                map.put("balance", String.valueOf(balance));
            }
        }

    }

    public void printUsers() {
        Iterator var1 = this.vector.iterator();

        while(var1.hasNext()) {
            Map<String, String> userInfo = (Map)var1.next();
            System.out.println(userInfo);
        }

    }

    public void seed() {
        this.vector.add(Map.of("phoneNum", "01149535899", "balance", "200"));
        this.vector.add(Map.of("phoneNum", "01140045708", "balance", "5"));
        this.vector.add(Map.of("phoneNum", "01150888345", "balance", "10"));
        this.vector.add(Map.of("phoneNum", "01117518970", "balance", "500"));
    }
}

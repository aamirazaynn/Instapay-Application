//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package paymentProviders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class NationalBankOfEgyptProvider implements BankProvider {
    private ArrayList<Map<String, String>> vector = new ArrayList();

    public NationalBankOfEgyptProvider() {
        this.seed();
    }

    public float getBalanceByCardNum(String cn) {
        Iterator var2 = this.vector.iterator();

        Map map;
        do {
            if (!var2.hasNext()) {
                return 0.0F;
            }

            map = (Map)var2.next();
        } while(!Objects.equals(map.get("cardNum"), cn));

        return Float.parseFloat((String)map.get("balance"));
    }

    public boolean matchData(String card, String phone) {
        Iterator var3 = this.vector.iterator();

        Map map;
        do {
            if (!var3.hasNext()) {
                return false;
            }

            map = (Map)var3.next();
        } while(!Objects.equals(map.get("cardNum"), card) || !Objects.equals(map.get("phoneNum"), phone));

        return true;
    }

    public void withdrawing(String cn, float amount) {
        Iterator var3 = this.vector.iterator();

        while(var3.hasNext()) {
            Map<String, String> map = (Map)var3.next();
            if (Objects.equals(map.get("cardNum"), cn)) {
                float balance = Float.parseFloat((String)map.get("balance"));
                balance -= amount;
                map.put("balance", Float.toString(balance));
            }
        }

    }

    public void deposit(String cn, float amount) {
        Iterator var3 = this.vector.iterator();

        while(var3.hasNext()) {
            Map<String, String> map = (Map)var3.next();
            if (Objects.equals(map.get("cardNum"), cn)) {
                float balance = Float.parseFloat((String)map.get("balance"));
                balance += amount;
                map.put("balance", Float.toString(balance));
            }
        }

    }

    public boolean isExist(String phone) {
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

    public void printUsers() {
        Iterator var1 = this.vector.iterator();

        while(var1.hasNext()) {
            Map<String, String> userInfo = (Map)var1.next();
            System.out.println(userInfo);
        }

    }

    public void seed() {
        this.vector.add(Map.of("cardNum", "123456789", "phoneNum", "01149535899", "balance", "0"));
        this.vector.add(Map.of("cardNum", "234567891", "phoneNum", "01140045708", "balance", "5"));
        this.vector.add(Map.of("cardNum", "345678912", "phoneNum", "01150888345", "balance", "10"));
        this.vector.add(Map.of("cardNum", "456789123", "phoneNum", "01117518970", "balance", "500"));
    }
}

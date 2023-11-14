//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package paymentProviders;

import java.util.*;

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
        Iterator<Map<String, String>> iterator = this.vector.iterator();

        while (iterator.hasNext()) {
            Map<String, String> map = iterator.next();
            if (Objects.equals(map.get("phoneNum"), cn)) {
                float balance = Float.parseFloat(map.get("balance"));
                balance -= amount;
                String newBalance = String.valueOf(balance);
                map.put("balance", newBalance);

            }
        }
    }

    public void deposit(String cn, float amount) {
        Iterator<Map<String, String>> iterator = this.vector.iterator();

        while (iterator.hasNext()) {
            Map<String, String> map = iterator.next();
            if (Objects.equals(map.get("phoneNum"), cn)) {
                float balance = Float.parseFloat(map.get("balance"));
                balance += amount;
                String newBalance = String.valueOf(balance);
                map.put("balance", newBalance);
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
        this.vector.add(createUserMap("123456789", "01149535899", "200"));
        this.vector.add(createUserMap("234567891", "01140045708", "5"));
        this.vector.add(createUserMap("345678912", "01150888345", "10"));
        this.vector.add(createUserMap("456789123", "01117518970", "500"));
    }

    public Map<String, String> createUserMap(String cardNum, String phoneNum, String balance) {
        Map<String, String> userMap = new HashMap<>();
        userMap.put("cardNum", cardNum);
        userMap.put("phoneNum", phoneNum);
        userMap.put("balance", balance);
        return userMap;
    }
}

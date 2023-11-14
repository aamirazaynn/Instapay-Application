package paymentProviders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class CIBProvider implements BankProvider {
    private ArrayList<Map<String, String>> vector = new ArrayList<>();

    public CIBProvider() {
        this.seed();
    }

    public float getBalanceByCardNum(String cn) {
        Iterator<Map<String, String>> iterator = this.vector.iterator();

        Map<String, String> map;
        do {
            if (!iterator.hasNext()) {
                return 0.0F;
            }

            map = iterator.next();
        } while (!Objects.equals(map.get("cardNum"), cn));

        return Float.parseFloat(map.get("balance"));
    }

    public boolean matchData(String card, String phone) {
        Iterator<Map<String, String>> iterator = this.vector.iterator();

        Map<String, String> map;
        do {
            if (!iterator.hasNext()) {
                return false;
            }

            map = iterator.next();
        } while (!Objects.equals(map.get("cardNum"), card) || !Objects.equals(map.get("phoneNum"), phone));

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

    public boolean isExist(String phone) {
        Iterator<Map<String, String>> iterator = this.vector.iterator();

        Map<String, String> map;
        do {
            if (!iterator.hasNext()) {
                return false;
            }

            map = iterator.next();
        } while (!Objects.equals(map.get("phoneNum"), phone));

        return true;
    }

    public void printUsers() {
        Iterator<Map<String, String>> iterator = this.vector.iterator();

        while (iterator.hasNext()) {
            Map<String, String> userInfo = iterator.next();
            System.out.println(userInfo);
        }
    }

    public void seed() {
        this.vector.add(createUserMap("123456789", "01149535899", "5000"));
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

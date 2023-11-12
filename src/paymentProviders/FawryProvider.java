package paymentProviders;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class FawryProvider implements ElectronicPaymentProvider{
    private ArrayList<Map<String, String>> vector = new ArrayList<>();
    public FawryProvider(){
        seed();
    }
    public float getBalanceByPhoneNumber(String phone) {
        for (Map<String, String> map : vector){
            if(Objects.equals(map.get("PhoneNum"), phone)){
                return Float.parseFloat(map.get("balance"));
            }
        }
        return 0;
    }
    public boolean matchPhoneNum(String phone) {
        for (Map<String, String> map : vector){
            if(Objects.equals(map.get("PhoneNum"), phone)){
                return true;
            }
        }
        return false;
    }
    public void withdrawing(String cn, float amount) {
        for (Map<String, String> map : vector){
            if(Objects.equals(map.get("PhoneNum"), cn)){
                float balance = Float.parseFloat(map.get("balance"));
                balance -= amount;
                map.put("balance", Float.toString(balance));
            }
        }
    }
    public void deposit(String cn, float amount) {
        for (Map<String, String> map : vector){
            if(Objects.equals(map.get("PhoneNum"), cn)){
                float balance = Float.parseFloat(map.get("balance"));
                balance += amount;
                map.put("balance", Float.toString(balance));
            }
        }
    }

    public void seed(){
        vector.add(Map.of(
                "phoneNum", "01149535899",
                "balance", "0"
        ));
        vector.add(Map.of(
                "phoneNum", "01140045708",
                "balance", "5"
        ));
        vector.add(Map.of(
                "phoneNum", "01150888345",
                "balance", "10"
        ));
        vector.add(Map.of(
                "phoneNum", "01117518970",
                "balance", "500"
        ));
    }
}

package paymentProviders;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class NationalBankOfEgyptProvider implements BankProvider{
    private ArrayList<Map<String, String>> vector = new ArrayList<>();
    public NationalBankOfEgyptProvider(){
        seed();
    }
    public float getBalanceByCardNum(String cn){
        for (Map<String, String> map : vector){
            if(Objects.equals(map.get("cardNum"), cn)){
                return Float.parseFloat(map.get("balance"));
            }
        }
        return 0;
    }
    public boolean matchData(String card, String phone){
        for (Map<String, String> map : vector){
            if(Objects.equals(map.get("cardNum"), card) && Objects.equals(map.get("phoneNum"), phone)){
                return true;
            }
        }
        return false;
    }
    public void withdrawing(String cn, float amount){
        for (Map<String, String> map : vector){
            if(Objects.equals(map.get("cardNum"), cn)){
                float balance = Float.parseFloat(map.get("balance"));
                balance -= amount;
                map.put("balance", Float.toString(balance));
            }
        }
    }
    public void deposit(String cn, float amount){
        for (Map<String, String> map : vector){
            if(Objects.equals(map.get("cardNum"), cn)){
                float balance = Float.parseFloat(map.get("balance"));
                balance += amount;
                map.put("balance", Float.toString(balance));
            }
        }
    }

    public boolean isExist(String phone) {
        for (Map<String, String> map : vector){
            if(Objects.equals(map.get("phoneNum"), phone)){
                return true;
            }
        }
        return false;
    }

    public void seed(){
        vector.add(Map.of(
                "cardNum", "123456789",
                "phoneNum", "01149535899",
                "balance", "0"
        ));
        vector.add(Map.of(
                "cardNum", "234567891",
                "phoneNum", "01140045708",
                "balance", "5"
        ));
        vector.add(Map.of(
                "cardNum", "345678912",
                "phoneNum", "01150888345",
                "balance", "10"
        ));
        vector.add(Map.of(
                "cardNum", "456789123",
                "phoneNum", "01117518970",
                "balance", "500"
        ));
    }
}
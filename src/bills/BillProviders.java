package bills;

import java.util.ArrayList;
import java.util.Map;

class WaterBillProvider  {
    private ArrayList<Map<String, String>> vector = new ArrayList<>();

    public float getAmountByCode(String code) {
        for (Map<String, String> item : vector) {
            if (item.get("code").equals(code)) {
                return Float.parseFloat(item.get("amount"));
            }
        }

        return 0;
    }
    public void payBill(String code) {
        for (Map<String, String> item : vector) {
            vector.removeIf(Item -> item.get("code").equals(code));
        }
    }
    public void seed(){
        vector.add(Map.of(
                "code", "2023",
                "amount", "900"
        ));
        vector.add(Map.of(
                "code", "2022",
                "amount", "910"
        ));
        vector.add(Map.of(
                "code", "2021",
                "amount", "920"
        ));
        vector.add(Map.of(
                "code", "2020",
                "amount", "930"
        ));
    }
}
class GasBillProvider  {
    private ArrayList<Map<String, String>> vector = new ArrayList<>();

    public float getAmountByCode(String code) {
        for (Map<String, String> item : vector) {
            if (item.get("code").equals(code)) {
                return Float.parseFloat(item.get("amount"));
            }
        }

        return 0;
    }
    public void payBill(String code) {
        for (Map<String, String> item : vector) {
            vector.removeIf(Item -> item.get("code").equals(code));
        }
    }
    public void seed(){
        vector.add(Map.of(
                "code", "2001",
                "amount", "500"
        ));
        vector.add(Map.of(
                "code", "2002",
                "amount", "600"
        ));
        vector.add(Map.of(
                "code", "2003",
                "amount", "700"
        ));
        vector.add(Map.of(
                "code", "2004",
                "amount", "800"
        ));
    }
}
class ElectricityBillProvider  {
    private ArrayList<Map<String, String>> vector = new ArrayList<>();

    public float getAmountByCode(String code) {
        for (Map<String, String> item : vector) {
            if (item.get("code").equals(code)) {
                return Float.parseFloat(item.get("amount"));
            }
        }

        return 0;
    }
    public void payBill(String code) {
        for (Map<String, String> item : vector) {
            vector.removeIf(Item -> item.get("code").equals(code));
        }

    }
    public void seed(){
        vector.add(Map.of(
                "code", "12345",
                "amount", "100"
        ));
        vector.add(Map.of(
                "code", "67891",
                "amount", "200"
        ));
        vector.add(Map.of(
                "code", "11121",
                "amount", "300"
        ));
        vector.add(Map.of(
                "code", "31415",
                "amount", "400"
        ));
    }
}

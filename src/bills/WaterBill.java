//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package bills;

class WaterBill implements PayBills {
    WaterBill() {
    }

    public boolean pay(String code, float balance) {
        WaterBillProvider w = new WaterBillProvider();
        if (w.getAmountByCode(code) > balance) {
            w.payBill(code);
            return true;
        } else {
            return false;
        }
    }
}

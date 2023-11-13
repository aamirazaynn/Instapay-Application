//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package bills;

class ElectricityBill implements PayBills {
    ElectricityBill() {
    }

    public boolean pay(String code, float balance) {
        ElectricityBillProvider e = new ElectricityBillProvider();
        if (e.getAmountByCode(code) > balance) {
            e.payBill(code);
            return true;
        } else {
            return false;
        }
    }
}

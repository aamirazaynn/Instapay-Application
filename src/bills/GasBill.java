//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package bills;

class GasBill implements PayBills {
    GasBill() {
    }

    public boolean pay(String code, float balance) {
        GasBillProvider g = new GasBillProvider();
        if (g.getAmountByCode(code) > balance) {
            g.payBill(code);
            return true;
        } else {
            return false;
        }
    }
}

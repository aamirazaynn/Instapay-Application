//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import bills.PayBills;
import java.util.Objects;
import paymentProviders.BankProvider;
import paymentProviders.CIBProvider;
import paymentProviders.NationalBankOfEgyptProvider;
import paymentProviders.VodafoneProvider;
import paymentProviders.WalletProvider;

public class UserController {
    private Transaction transaction;
    private PayBills payBills;

    public UserController() {
    }

    public Transaction getTransaction() {
        return this.transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public PayBills getPayBills() {
        return this.payBills;
    }

    public void setPayBills(PayBills payBills) {
        this.payBills = payBills;
    }

    public void transferMoney(User fromUser, float amount, String toUser, String toProvider, ApplicationData applicationData) {
        System.out.println(fromUser.getBalance());
        if (fromUser.getBalance() < amount) {
            System.out.println("Your balance is not enough :(");
        } else {
            String phoneNum = fromUser.getPhoneNumber();
            String providerName = fromUser.getProvider().toString();
            if (Objects.equals(fromUser.getUsertype().toString(), "BANK")) {
                this.transaction.transfer(amount, toUser, toProvider, applicationData);
                Object b;
                if (Objects.equals(providerName, "NATIONALBANKOFEGYPT")) {
                    b = new NationalBankOfEgyptProvider();
                } else {
                    b = new CIBProvider();
                }

                ((BankProvider)b).withdrawing(phoneNum, amount);
            } else if (Objects.equals(fromUser.getUsertype().toString(), "WALLET")) {
                this.transaction.transfer(amount, toUser, toProvider, applicationData);
                WalletProvider w = new VodafoneProvider();
                w.withdrawing(phoneNum, amount);
            }
        }

    }
}

import bills.BillProviderInterface;
import bills.PayBills;
import java.util.Objects;

import paymentProviders.*;
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

    public void transferMoney(User fromUser, float amount, String toUser, ProviderInterface toProvider, ApplicationData applicationData, ProviderInterface b) {
        if (fromUser.getBalance() < amount) {
            System.out.println("Your balance is not enough :(");
        } else {
            String phoneNum = fromUser.getPhoneNumber();
            if (Objects.equals(fromUser.getUsertype().toString(), "BANK")) {
                this.transaction.transfer(amount, toUser, toProvider, applicationData);
                fromUser.setBalance(fromUser.getBalance() - amount);
                b.withdrawing(phoneNum, amount);
            } else if (Objects.equals(fromUser.getUsertype().toString(), "WALLET")) {
                this.transaction.transfer(amount, toUser, toProvider, applicationData);
                fromUser.setBalance(fromUser.getBalance() - amount);
                b.withdrawing(phoneNum, amount);
            }
        }
    }

    public void payBills(User user, String code, BillProviderInterface billProviderInterface, ProviderInterface providerInterface) {
        float amount = payBills.getAmountByCode(code, billProviderInterface);
        if(amount < user.getBalance()){
            payBills.pay(code, billProviderInterface);
            providerInterface.withdrawing(user.getPhoneNumber(), amount);
        } else {
            System.out.println("Your balance is not enough :(");
        }
    }
}

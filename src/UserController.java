import bills.PayBills;

public class UserController {
    private Transaction transaction;
    private PayBills payBills;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public PayBills getBayBells() {
        return payBills;
    }

    public void setPayBills(PayBills bayBills) {
        this.payBills = bayBills;
    }

    public void transferMoney(User fromUser, float amount, String toUser, String toProvider, ApplicationData applicationData){
        if(fromUser.getBalance() < amount){
            return;
        } else{
            if(TransactionValidations.isValidCardNumber(toUser)){ // bank
                transaction.transfer(amount, toUser, toProvider, applicationData);
            } else if (TransactionValidations.isValidPhoneNumber(toUser)) { // wallet
                transaction.transfer(amount, toUser, toProvider, applicationData);
            } else { // instapay
                transaction.transfer(amount, toUser, toProvider, applicationData);
            }
        }
    }
}

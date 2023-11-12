import paymentProviders.*;

import java.util.Objects;

public class InstapayTransaction implements Transaction {
    public boolean transfer(float amount, String toUser, String toProvider, ApplicationData applicationData) {
        String phoneNum = applicationData.getPhoneNumByUsername(toUser);
        String type = applicationData.getUserType(toUser);
        if(Objects.equals(type, "BANK")) {
            BankProvider b;
            if(Objects.equals(toProvider, "CIB")){
                b = new CIBProvider();
            } else{
                b = new NationalBankOfEgyptProvider();
            }
            if(b.isExist(toProvider)){
                b.deposit(phoneNum, amount);
                return true;
            }
            return false;
        } else{
            WalletProvider w = new VodafoneProvider();
            if(w.matchPhoneNum(phoneNum)){
                w.deposit(phoneNum, amount);
                return true;
            } else{
                return false;
            }
        }
    }
}
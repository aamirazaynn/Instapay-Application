import java.util.Objects;
import java.util.Scanner;
import paymentProviders.*;
import paymentProviders.BankProvider;
import paymentProviders.CIBProvider;
import paymentProviders.NationalBankOfEgyptProvider;
import paymentProviders.VodafoneProvider;
import paymentProviders.WalletProvider;

public class Main {

    public static void main(String[] args) {
        ApplicationData applicationData = new LocalStorage();
        BankProvider cibProvider = new CIBProvider();
        BankProvider nationalBankOfEgyptProvider = new NationalBankOfEgyptProvider();
        WalletProvider walletProvider = new VodafoneProvider();
        Transaction transaction;

        while (true) {
            System.out.print("1. SignUp, 2. SignIn, 3.Exit: ");
            Scanner scanner = new Scanner(System.in);
            char choice = scanner.next().charAt(0);
            switch (choice) {
                // --------------------------------------sign up -----------------------------------------------
                case '1': {
                    SignUp signUp;
                    System.out.print("1. Bank, 2. Wallet: ");
                    char userType = scanner.next().charAt(0);
                    switch (userType) {
                        // ------------------------ Bank --------------------------------
                        case '1':
                        {
                            signUp = new BankSignUp();
                            System.out.print("Enter your card number: ");
                            String cardNum = scanner.next();
                            ((BankSignUp) signUp).setCardNumber(cardNum);
                            System.out.print("Enter your phone number: ");
                            String phoneNumber = scanner.next();
                            signUp.setPhoneNumber(phoneNumber);
                            System.out.print("Enter your username: ");
                            String username = scanner.next();
                            signUp.setUserName(username);
                            System.out.print("Enter your password: ");
                            String password = scanner.next();
                            signUp.setPassword(password);
                            System.out.print("1. CIB, 2. National Bank of Egypt: ");
                            char providerChoice = scanner.next().charAt(0);
                            if (providerChoice == '1') {
                                signUp.setProviderName("CIB");
                                signUp.register(applicationData, cibProvider);
                            } else {
                                signUp.setProviderName("NATIONALBANKOFEGYPT");
                                signUp.register(applicationData, nationalBankOfEgyptProvider);
                            }
                        };
                        break;
                        // ------------------------ Wallet --------------------------------
                        case '2':
                        {
                            signUp = new WalletSignUp();
                            System.out.print("Enter your phone number: ");
                            String phoneNumber = scanner.next();
                            signUp.setPhoneNumber(phoneNumber);
                            System.out.print("Enter your username: ");
                            String username = scanner.next();
                            signUp.setUserName(username);
                            System.out.print("Enter your password: ");
                            String password = scanner.next();
                            signUp.setPassword(password);
                            signUp.setProviderName("VODAFONE");
                            signUp.register(applicationData, walletProvider);
                        };
                        break;
                    }
                }
                    break;
                // --------------------------------------sign in -----------------------------------------------
                case '2': {
                    SignIn signIn = new SignIn();
                    System.out.print("Enter your username: ");
                    String userName = scanner.next();
                    signIn.setUserName(userName);
                    System.out.print("Enter your password: ");
                    String password = scanner.next();
                    signIn.setPassword(password);
                    if(signIn.confirmSignIn(applicationData)){
                        System.out.println("Logged in successfully");
                    }
                    boolean loop = true;
                    while(loop) {
                        if (signIn.confirmSignIn(applicationData)) {
                            User loggedInUser = applicationData.getUser(userName);
                            System.out.print("1. Transfer, 2. PayBills, 3. Logout: ");
                            char operation = scanner.next().charAt(0);
                            UserController userController = new UserController();
                            ProviderInterface fromProvider;
                            if(Objects.equals(loggedInUser.getProvider().toString(), "VODAFONE")){
                                fromProvider = walletProvider;
                            } else if(Objects.equals(loggedInUser.getProvider().toString(), "CIB")){
                                fromProvider = cibProvider;
                            } else{
                                fromProvider = nationalBankOfEgyptProvider;
                            }
                            //----------------------------------------operations----------------------------------------
                            switch (operation) {
                                // -----------------------------------transfer money------------------------------------
                                case '1':{
                                    if (loggedInUser.getUsertype() == Usertype.WALLET) {
                                        System.out.print("1. Wallet, 2.InstaPay Account: ");
                                    } else if (loggedInUser.getUsertype() == Usertype.BANK) {
                                        System.out.print("1. Wallet, 2.InstaPay Account, 3. Bank: ");
                                    }
                                    char transferType = scanner.next().charAt(0);
                                    float amount;
                                    String toUser;
                                    switch (transferType) {
                                        // ------------------------ to wallet ------------------------------------------
                                        case '1':{
                                            transaction = new WalletTransaction();
                                            userController.setTransaction(transaction);
                                            System.out.print("Enter the amount you want to transfer: ");
                                            amount = scanner.nextFloat();
                                            System.out.print("Enter the phone number you want to transfer to: ");
                                            toUser = scanner.next();
                                            userController.transferMoney(loggedInUser, amount, toUser, walletProvider, applicationData, fromProvider);
                                        }
                                        break;
                                        // -------------------------- to instapay --------------------------------------
                                        case '2': {
                                            transaction = new InstapayTransaction();
                                            userController.setTransaction(transaction);
                                            System.out.print("Enter the amount you want to transfer: ");
                                            amount = scanner.nextFloat();
                                            System.out.print("Enter the username you want to transfer to: ");
                                            toUser = scanner.next();
                                            if(Objects.equals(applicationData.getUserProvider(toUser), "CIB")){
                                                userController.transferMoney(loggedInUser, amount, toUser, cibProvider, applicationData, fromProvider);
                                            } else if(Objects.equals(applicationData.getUserProvider(toUser), "NATIONALBANKOFEGYPT")){
                                                userController.transferMoney(loggedInUser, amount, toUser, nationalBankOfEgyptProvider, applicationData, fromProvider);
                                            } else {
                                                userController.transferMoney(loggedInUser, amount, toUser, walletProvider, applicationData, fromProvider);
                                            }
                                        }
                                        break;
                                        // ---------------------------- to bank ----------------------------------------
                                        case '3': {
                                            transaction = new BankTransaction();
                                            userController.setTransaction(transaction);
                                            System.out.print("Enter the amount you want to transfer: ");
                                            amount = scanner.nextFloat();
                                            System.out.print("Enter the phone number you want to transfer to: ");
                                            toUser = scanner.next();
                                            System.out.print("Which bank you want to transfer to, 1. CIB, 2. National Bank of Egypt: ");
                                            char bankChoice = scanner.next().charAt(0);
                                            switch (bankChoice) {
                                                case '1': {
                                                    userController.transferMoney(loggedInUser, amount, toUser, cibProvider, applicationData, fromProvider);
                                                }
                                                break;
                                                case '2': {
                                                    userController.transferMoney(loggedInUser, amount, toUser, nationalBankOfEgyptProvider, applicationData, fromProvider);
                                                }
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                                // ------------------------------------pay bills----------------------------------------
                                case '2': {

                                }
                                break;
                                // -----------------------------------logout-------------------------------------------
                                case '3': {
                                    loop = false;
                                }
                                break;
                            }
                        }
                    }
                }
                    break;
                case '3':
                    System.exit(0);
            }
        }
    }
}

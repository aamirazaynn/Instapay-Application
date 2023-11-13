import java.util.Scanner;
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

        while (true) {
            System.out.print("1. SignUp, 2. SignIn, 3.Exit: ");
            Scanner scanner = new Scanner(System.in);
            char choice = scanner.next().charAt(0);
            switch (choice) {
                // --------------------------------------sign in -----------------------------------------------
                case '1': {
                    SignUp signUp;
                    System.out.print("1. Bank, 2. Wallet: ");
                    char userType = scanner.next().charAt(0);
                    switch (userType) {
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
                                ((BankSignUp) signUp).register(applicationData, cibProvider);
                            } else {
                                signUp.setProviderName("NATIONALBANKOFEGYPT");
                                ((BankSignUp) signUp).register(applicationData, nationalBankOfEgyptProvider);
                            }
                        };
                        break;
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
                            ((WalletSignUp) signUp).register(applicationData, walletProvider);
                        };
                        break;
                    }
                }
                    break;
                // --------------------------------------sign up -----------------------------------------------
                case '2':
                {
                    SignIn signIn = new SignIn();
                    System.out.print("Enter your username: ");
                    String userName = scanner.next();
                    signIn.setUserName(userName);
                    System.out.print("Enter your password: ");
                    String password = scanner.next();
                    signIn.setPassword(password);
                    if (signIn.confirmSignIn(applicationData)) {
                        System.out.println("Logged in successfully");
                        User loggedInUser = applicationData.getUser(userName);
                        System.out.print("1. Transfer, 2. PayBills, 3. Logout: ");
                        char operation = scanner.next().charAt(0);
                        UserController userController = new UserController();
                        //----------------------------------------operations-----------------------------------------
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
                                    // ------------------------ to wallet --------------------------------------------
                                    case '1':{
                                        System.out.print("Enter the amount you want to transfer: ");
                                        amount = scanner.nextFloat();
                                        System.out.print("Enter the phone number you want to transfer to: ");
                                        toUser = scanner.next();
                                        walletProvider.printUsers();
                                        System.out.println("------------------------------------------");
                                        userController.transferMoney(loggedInUser, amount, toUser, "VODAFONE", applicationData);
                                        walletProvider.printUsers();
                                    }
                                    break;
                                    // -------------------------- to instapay ---------------------------------------
                                    case '2': {
                                        System.out.print("Enter the amount you want to transfer: ");
                                        amount = scanner.nextFloat();
                                        System.out.print("Enter the username you want to transfer to: ");
                                        toUser = scanner.next();
                                        userController.transferMoney(loggedInUser, amount, toUser, "INSTAPAY", applicationData);
                                    }
                                    break;

                                    case '3': {
                                        // ----------------------- to bank ---------------------------------------------
                                        System.out.print("Enter the amount you want to transfer: ");
                                        amount = scanner.nextFloat();
                                        System.out.print("Enter the phone number you want to transfer to: ");
                                        toUser = scanner.next();
                                        System.out.print("Which bank you want to transfer to, 1. CIB, 2. National Bank of Egypt: ");
                                        char bankChoice = scanner.next().charAt(0);
                                        switch (bankChoice) {
                                            case '1': {
                                                cibProvider.printUsers();
                                                System.out.println("------------------------------------------");
                                                userController.transferMoney(loggedInUser, amount, toUser, "CIB", applicationData);
                                                cibProvider.printUsers();
                                            }
                                                break;
                                            case '2': {
                                                nationalBankOfEgyptProvider.printUsers();
                                                System.out.println("------------------------------------------");
                                                userController.transferMoney(loggedInUser, amount, toUser, "NATIONALBANKOFEGYPT", applicationData);
                                                nationalBankOfEgyptProvider.printUsers();
                                            }
                                                break;
                                        }
                                    }
                                    break;
                                }
                            }
                                break;
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

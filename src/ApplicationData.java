//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public interface ApplicationData {
    void addUser(User var1);

    User getUser(String var1);

    String getPassByUserName(String var1);

    String getPhoneNumByUsername(String var1);

    String getUserProvider(String var1);

    String getUserType(String var1);

    boolean isUserExist(String var1);

    void printUsers();
}

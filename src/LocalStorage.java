//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class LocalStorage implements ApplicationData {
    private Vector<Map<String, String>> users = new Vector();

    public LocalStorage() {
    }

    public void addUser(User user) {
        Map<String, String> userInfo = new HashMap();
        userInfo.put("username", user.getUsername());
        userInfo.put("password", user.getPassword());
        userInfo.put("provider", user.getProvider().toString());
        userInfo.put("phoneNumber", user.getPhoneNumber());
        userInfo.put("balance", Float.toString(user.getBalance()));
        userInfo.put("type", user.getUsertype().toString());
        this.users.add(userInfo);
    }

    public User getUser(String username) {
        Iterator var2 = this.users.iterator();

        Map map;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            map = (Map)var2.next();
        } while(!username.equals(map.get("username")));

        return new User((String)map.get("username"), (String)map.get("password"), Float.parseFloat((String)map.get("balance")), (String)map.get("phoneNumber"), (String)map.get("provider"), (String)map.get("type"));
    }

    public String getPassByUserName(String userName) {
        Iterator var2 = this.users.iterator();

        Map userInfo;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            userInfo = (Map)var2.next();
        } while(!userName.equals(userInfo.get("username")));

        return (String)userInfo.get("password");
    }

    public String getPhoneNumByUsername(String username) {
        Iterator var2 = this.users.iterator();

        Map userInfo;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            userInfo = (Map)var2.next();
        } while(!username.equals(userInfo.get("username")));

        return (String)userInfo.get("phoneNumber");
    }

    public String getUserProvider(String username) {
        Iterator var2 = this.users.iterator();

        Map userInfo;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            userInfo = (Map)var2.next();
        } while(!username.equals(userInfo.get("username")));

        return (String)userInfo.get("provider");
    }

    public String getUserType(String username) {
        Iterator var2 = this.users.iterator();

        Map userInfo;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            userInfo = (Map)var2.next();
        } while(!username.equals(userInfo.get("username")));

        return (String)userInfo.get("type");
    }

    public boolean isUserExist(String username) {
        Iterator var2 = this.users.iterator();

        Map userInfo;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            userInfo = (Map)var2.next();
        } while(!username.equals(userInfo.get("username")));

        return true;
    }

    public void updateBalance(String username, float balance) {
        for (Map<String, String> userInfo : this.users) {
            if (username.equals(userInfo.get("username"))) {
                userInfo.put("balance", Float.toString(balance));
            }
        }
    }

    public void printUsers() {
        Iterator var1 = this.users.iterator();

        while(var1.hasNext()) {
            Map<String, String> userInfo = (Map)var1.next();
            System.out.println(userInfo);
        }

    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class LocalStorage implements ApplicationData {
    private Vector<Map<String, String>> users;

    public LocalStorage() {
        this.users = new Vector<>();
    }

    public void addUser(User user) {
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("username", user.getUserInfo().getUsername());
        userInfo.put("password", user.getUserInfo().getPassword());
        userInfo.put("provider", user.getProvider().toString());
        userInfo.put("phoneNumber", user.getPhoneNumber());
        users.add(userInfo);
    }

    public String getPassByUserName(String userName) {
        for (Map<String, String> userInfo : users) {
            if (userName.equals(userInfo.get("username"))) {
                return userInfo.get("password");
            }
        }
        return null;
    }
    public String getPhoneNumByUsername(String username){
        for (Map<String, String> userInfo : users) {
            if (username.equals(userInfo.get("username"))) {
                return userInfo.get("phoneNumber");
            }
        }
        return null;
    }
    public String getUserProvider(String username){
        for (Map<String, String> userInfo : users) {
            if (username.equals(userInfo.get("username"))) {
                return userInfo.get("type");
            }
        }
        return null;
    }
    public String getUserType(String username){
        for (Map<String, String> userInfo : users) {
            if (username.equals(userInfo.get("username"))) {
                return userInfo.get("type");
            }
        }
        return null;
    }
}

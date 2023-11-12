public interface ApplicationData {

    public void addUser(User user);
    public String getPassByUserName(String userName);
    public String getPhoneNumByUsername(String username);
    public String getUserProvider(String username);
    public String getUserType(String username);
}

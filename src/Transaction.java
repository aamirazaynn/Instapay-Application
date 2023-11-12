public interface Transaction {
    public boolean transfer(float amount, String toUser, String toProvider, ApplicationData applicationData);
}
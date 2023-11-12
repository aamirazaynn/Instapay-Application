public interface Transaction {
    public void transfer(float amount, String toUser, String toProvider, ApplicationData applicationData);
}
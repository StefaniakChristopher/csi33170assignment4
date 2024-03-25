public interface Audit {

    boolean permit(long acctNumber, double balance);
    // other methods
}

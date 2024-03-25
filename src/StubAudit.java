public class StubAudit implements Audit {
    public boolean permit(long acctNumber, double balance) {
        System.out.println("StubAudit permit called");
        return true;
    }
}

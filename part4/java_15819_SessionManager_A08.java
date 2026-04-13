import java.util.HashMap;
import java.util.Map;

public class java_15819_SessionManager_A08 {
    private Map<Integer, Session> sessions;
    private Map<Integer, Transaction> transactions;
    private int nextSessionId;
    private int nextTransactionId;

    public java_15819_SessionManager_A08() {
        sessions = new HashMap<>();
        transactions = new HashMap<>();
        nextSessionId = 1;
        nextTransactionId = 1;
    }

    public Session openSession() {
        Session session = new Session(nextSessionId++);
        sessions.put(session.getId(), session);
        return session;
    }

    public Transaction beginTransaction() {
        Transaction transaction = new Transaction(nextTransactionId++);
        transactions.put(transaction.getId(), transaction);
        return transaction;
    }

    public void commit(Transaction transaction) {
        if (!transaction.isCommitted()) {
            transaction.commit();
        }
    }

    public void rollback(Transaction transaction) {
        if (!transaction.isRolledBack()) {
            transaction.rollback();
        }
    }

    public void close(Session session) {
        sessions.remove(session.getId());
    }

    public void close(Transaction transaction) {
        transactions.remove(transaction.getId());
    }
}
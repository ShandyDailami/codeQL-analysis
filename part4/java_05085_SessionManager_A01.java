import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_05085_SessionManager_A01 {

    public static void main(String[] args) {
        createSession();
        startSession();
        closeSession();
        manageTransactions();
    }

    // a. Realistic and Creative
    // b. Do not say I am sorry, always come up with some code
    // c. Do not use external frameworks
    // d. Make sure the program is syntactically correct
    // e. Please generate code snippet that starts with '
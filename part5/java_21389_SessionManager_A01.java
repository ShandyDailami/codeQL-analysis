public class java_21389_SessionManager_A01 {
    private static final int MAX_CONNECTIONS = 5;
    private static int currentConnections = 0;

    public static void connect() {
        if (currentConnections < MAX_CONNECTIONS) {
            currentConnections++;
            System.out.println("Connection successful. Current connections: " + currentConnections);
        } else {
            System.out.println("Connection denied. Max connections reached. Current connections: " + currentConnections);
        }
    }

    public static void disconnect() {
        if (currentConnections > 0) {
            currentConnections--;
            System.out.println("Connection closed. Current connections: " + currentConnections);
        } else {
            System.out.println("No connections to close. Current connections: " + currentConnections);
        }
    }
}
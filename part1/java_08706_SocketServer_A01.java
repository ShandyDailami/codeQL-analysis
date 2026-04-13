import java.io.*;
import java.net.*;

public class java_08706_SocketServer_A01 {
    private static int MAX_CONNECTIONS = 5;
    private static Socket[] clients = new Socket[MAX_CONNECTIONS];
    private static int availableSlots = 0;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(5000);
            System.out.println("Server started at port 5000");
            while (true) {
                if (availableSlots == 0) {
                    System.out.println("Closing connection to the client");
                    clients[0].close();
                    System.arraycopy(clients, 1, clients, 0, clients.length - 1);
                    availableSlots--;
                } else {
                    Socket newClient = serverSocket.accept();
                    System.out.println("New connection accepted from " + newClient.getRemoteSocketAddress());
                    clients[availableSlots] = newClient;
                    availableSlots++;
                    newConnection(newClient);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private static void newConnection(Socket client) {
        // Your code here
    }
}
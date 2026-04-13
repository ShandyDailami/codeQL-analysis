import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_25276_SocketServer_A03 {
    private static String USERNAME = "user";
    private static String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);
            System.out.println("Waiting for client authentication...");
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client authenticated!");
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                if ("exit".equals(message)) {
                    break;
                }
                if (message.equals(USERNAME + ":" + PASSWORD)) {
                    writer.println("Login successful!");
                } else {
                    writer.println("Invalid username or password!");
                }
            }
            writer.close();
            reader.close();
            clientSocket.close();
        } finally {
            serverSocket.close();
        }
    }
}
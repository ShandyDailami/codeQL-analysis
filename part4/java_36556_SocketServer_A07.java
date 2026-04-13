import java.io.*;
import java.net.*;
import java.util.*;

public class java_36556_SocketServer_A07 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";
    private static final String USER_CREDENTIALS = USERNAME + ":" + PASSWORD;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(1234); // open port 1234
            System.out.println("Server started on port: " + serverSocket.getLocalPort());

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new connection from: " + clientSocket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                String clientMsg = in.readUTF();
                System.out.println("Received: " + clientMsg);

                String[] credentials = clientMsg.split(":");
                if (USERNAME.equals(credentials[0]) && PASSWORD.equals(credentials[1])) {
                    DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                    out.writeUTF("Authentication successful");
                    System.out.println("Sent: Authentication successful");
                } else {
                    DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                    out.writeUTF("Authentication failed");
                    System.out.println("Sent: Authentication failed");
                }

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
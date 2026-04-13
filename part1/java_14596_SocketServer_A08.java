import java.io.*;
import java.net.*;
import java.util.*;

public class java_14596_SocketServer_A08 {
    private static final String SERVER_STATUS = "Server Started!";
    private static final String CLIENT_STATUS = "Client Connected!";
    private static ServerSocket server;
    private static Socket clientSocket;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(3333);
            System.out.println("Waiting for client on port: " + server.getLocalPort());

            while (true) {
                clientSocket = server.accept();
                System.out.println(CLIENT_STATUS);

                DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String clientMessage, serverMessage;

                // Read from client
                clientMessage = inFromClient.readLine();
                System.out.println("Received: " + clientMessage);

                // Echo back to client
                serverMessage = "Echo: " + clientMessage;
                outToClient.writeBytes(serverMessage + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
                if (clientSocket != null) clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
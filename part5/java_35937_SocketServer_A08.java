import java.io.*;
import java.net.*;

public class java_35937_SocketServer_A08 {
    private static final String SERVER_NAME = "SecureSocketServer";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println(SERVER_NAME + " listening on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client " + clientSocket.getRemoteSocketAddress() + " connected");

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                // Check the integrity of the data
                int data = in.readInt();
                if (data != checkIntegrity(data)) {
                    System.out.println("Data integrity check failed, closing connection");
                    clientSocket.close();
                    continue;
                }

                // Process the data
                // ...

                out.writeUTF("Data processed successfully");
                out.flush();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int checkIntegrity(int data) {
        // Implement your own checks here and return the result
        // This example simply returns the data
        return data;
    }
}
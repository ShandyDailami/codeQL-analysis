import java.io.*;
import java.net.*;

public class java_25148_SocketServer_A08 {
    private static int port = 1234;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                // Receive the message from the client
                String message = in.readUTF();
                System.out.println("Received message: " + message);

                // Verify the integrity of the message
                if (verifyIntegrity(message)) {
                    System.out.println("Integrity verified. Sending acknowledgment.");
                    out.writeUTF("Acknowledgment");
                } else {
                    System.out.println("Integrity verification failed. Sending error message.");
                    out.writeUTF("Error: Message integrity failed.");
                }

                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean verifyIntegrity(String message) {
        // This is a simple example of a verification mechanism. In a real scenario,
        // you would likely calculate a hash of the message and compare it to a known value.
        // The following is a naive implementation that simply checks if the message is empty.
        return message.isEmpty();
    }
}
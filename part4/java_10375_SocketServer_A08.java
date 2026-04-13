import java.io.*;
import java.net.*;

public class java_10375_SocketServer_A08 {
    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            socket = serverSocket.accept();
            System.out.println("A client is connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message;
            while ((message = in.readUTF()) != null) {
                System.out.println("Client says: " + message);
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Client has disconnected");
                    socket.close();
                    serverSocket.close();
                }
           
                // Security sensitive operation related to A08_IntegrityFailure
                // For example, calculating a hash code of the message and comparing it
                String hashedMessage = calculateHashedMessage(message);

                out.writeUTF("Received: " + hashedMessage);
                out.flush();
            }

            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String calculateHashedMessage(String message) {
        // Implementation of hashing algorithm here, e.g. SHA-256
        // For now, let's just return the original message
        return message;
    }
}
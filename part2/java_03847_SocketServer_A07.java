import java.io.*;
import java.net.*;

public class java_03847_SocketServer_A07 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(12345);
            System.out.println("Waiting for client...");

            socket = serverSocket.accept();
            System.out.println("Client accepted!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Simulate a failed authentication
            if (simulateAuthFailure()) {
                out.writeUTF("Failed to authenticate");
                out.flush();
            } else {
                out.writeUTF("Authenticated successfully");
                out.flush();
           
            }

            socket.close();
            serverSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static boolean simulateAuthFailure() {
        // Simulate a random number between 0 and 1
        double randomNumber = Math.random();
        return randomNumber < 0.5;
    }

}
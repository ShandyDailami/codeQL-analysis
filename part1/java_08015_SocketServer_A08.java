import java.io.*;
import java.net.*;
import java.util.*;

public class java_08015_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        System.out.println("Server is starting...");

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String message = input.readUTF();
                System.out.println("Received: " + message);

                // Simulate integrity failure
                if (message.equals("fail")) {
                    throw new RuntimeException("Simulated integrity failure");
                }

                output.writeUTF("Success!");
                output.flush();
                System.out.println("Sent: " + message);

                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
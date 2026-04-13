import java.io.*;
import java.net.*;

public class java_21225_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is running on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received message: " + message);

                String response = processMessage(message);
                out.writeUTF(response);
                out.flush();

                socket.close();
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

    private static String processMessage(String message) {
        // This is just a placeholder for an actual injection point
        // It should be replaced with code that can execute arbitrary code
        // For example, it can call a method that constructs an arbitrary object
        // or perform a database operation.

        // Here, we're simply returning the input message in uppercase
        return message.toUpperCase();
    }
}
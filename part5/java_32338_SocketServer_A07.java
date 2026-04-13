import java.io.*;
import java.net.*;

public class java_32338_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is running on port 8080...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected...");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request = in.readUTF();
                System.out.println("Received: " + request);

                // Simulate a security-sensitive operation
                String response = "Server response: " + request;
                out.writeUTF(response);
                out.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.io.*;
import java.net.*;

public class java_40104_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started on port 12345");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted connection from: " + socket.getRemoteSocketAddress());

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Only accept connections from specific IP
                InetAddress clientAddress = socket.getRemoteSocketAddress();
                String clientIP = clientAddress.getHostAddress();
                if (!clientIP.equals("192.168.0.1")) {
                    System.out.println("Connection from " + clientIP + " is not accepted.");
                    continue;
                }

                String message = input.readUTF();
                System.out.println("Received message: " + message);

                output.writeUTF("Message received");
                output.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
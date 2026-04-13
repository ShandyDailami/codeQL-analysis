import java.io.*;
import java.net.*;
import java.util.*;

public class java_18059_SocketServer_A08 {
    private static final String SERVER_SOFTWARE = "Vanilla Java SocketServer/1.0";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server is listening on port 8189");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Step 1: Verify the Client's Identity
            String clientIdentity = in.readUTF();
            System.out.println("Client identity: " + clientIdentity);

            // Step 2: Verify the Client's IP
            InetAddress clientAddress = socket.getInetAddress();
            System.out.println("Client IP: " + clientAddress.getHostAddress());

            // Step 3: Verify the Client's Port
            int clientPort = socket.getPort();
            System.out.println("Client port: " + clientPort);

            // Step 4: Verify the Client's Timestamps
            long clientStartTime = System.currentTimeMillis();
            long clientEndTime = in.readLong();
            long clientElapsedTime = clientEndTime - clientStartTime;
            System.out.println("Client elapsed time: " + clientElapsedTime);

            // Step 5: Verify the Client's Message
            String clientMessage = in.readUTF();
            System.out.println("Client message: " + clientMessage);

            // Step 6: Send a response
            String response = "Server accepts client's request";
            out.writeUTF(response);
            out.close();

            socket.close();
        }
    }
}
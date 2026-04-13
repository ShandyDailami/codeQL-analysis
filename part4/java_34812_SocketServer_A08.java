import java.net.*;
import java.io.*;

public class java_34812_SocketServer_A08 {
    public static void main(String[] args) {
        // Create a socket
        Socket socket;
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(2402); // port number
            System.out.println("Waiting for client on port " +
                    serverSocket.getLocalPort() + "...");

            socket = serverSocket.accept();
            System.out.println("Connected to client " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Handle security-sensitive operations related to A08_IntegrityFailure
            String receivedData = in.readUTF();
            System.out.println("Received: " + receivedData);

            if (receivedData.equals("Fail")) {
                throw new SecurityException("Failed due to SecurityFailure A08_IntegrityFailure");
            }

            out.writeUTF("Successfully processed");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}
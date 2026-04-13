import java.net.*;
import java.io.*;

public class java_06761_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Waiting for client on port: " +
                serverSocket.getLocalPort() + "...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted new connection from " +
                    clientSocket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            out.writeUTF("Thank you for connecting to " +
                    clientSocket.getRemoteSocketAddress());
            out.flush();

            clientSocket.close();
        }
    }
}
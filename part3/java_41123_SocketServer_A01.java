import java.io.*;
import java.net.*;

public class java_41123_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // read and send request from the client
            String request = in.readUTF();
            System.out.println("Received request: " + request);

            // send response back to client
            out.writeUTF("Server response: " + request);
            out.flush();

            clientSocket.close();
        }
    }
}
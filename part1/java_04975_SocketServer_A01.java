import java.io.*;
import java.net.*;

public class java_04975_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // create server socket
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is running...");

        // accept client
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client is connected...");

        // create input stream
        DataInputStream in = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

        // read username
        String username = in.readUTF();
        System.out.println("Username received: " + username);

        // send response
        out.writeUTF("Hello " + username);

        // close connection
        clientSocket.close();
        serverSocket.close();
    }
}
import java.io.*;
import java.net.*;
import java.util.*;

public class java_17499_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dis.readUTF();
            System.out.println("Client message: " + clientMessage);

            String serverResponse = "Hello, client";
            dos.writeUTF(serverResponse);
            System.out.println("Server response: " + serverResponse);

            socket.close();
        }
    }
}
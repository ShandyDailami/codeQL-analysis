import java.io.*;
import java.net.*;
import java.util.*;

public class java_29553_SocketServer_A01 {
    private static int portNumber = 6000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(portNumber);
        System.out.println("Server started on port " + portNumber);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received message: " + message);

            String response = "Message received";
            output.writeUTF(response);
            System.out.println("Sent message: " + response);

            socket.close();
       
        }
    }
}
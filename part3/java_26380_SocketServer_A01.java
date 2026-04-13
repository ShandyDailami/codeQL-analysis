import java.net.*;
import java.io.*;
import java.util.*;

public class java_26380_SocketServer_A01 {
    private static int port = 8080;
    private static ServerSocket serverSocket;
    private static Socket socket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while(true) {
                socket = serverSocket.accept();
                System.out.println("A client connected");

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String clientMessage = input.readUTF();
                System.out.println("Received message: " + clientMessage);

                String serverMessage = "Hello, Client!";
                output.writeUTF(serverMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
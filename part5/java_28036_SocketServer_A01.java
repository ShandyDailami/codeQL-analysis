import java.io.*;
import java.net.*;

public class java_28036_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Server is listening on port 6000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client has connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientMessage = input.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Hello, Client, you are connected to the server!";
            output.writeUTF(serverMessage);
            System.out.println("Server says: " + serverMessage);

            socket.close();
        }
    }
}
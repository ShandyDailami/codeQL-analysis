import java.io.*;
import java.net.*;

public class java_26100_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // port number
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept(); // wait for a client
            System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            String clientMessage = inputStream.readUTF(); // read a message from client
            System.out.println("Received: " + clientMessage);

            String serverMessage = "Hello, Client!";
            outputStream.writeUTF(serverMessage); // write a message to client

            socket.close(); // close the connection
        }
    }
}
import java.io.*;
import java.net.*;
import java.util.*;

public class java_40668_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server started");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String request = dataInputStream.readUTF();
            System.out.println("Received request: " + request);

            if (request.equalsIgnoreCase("exit")) {
                break;
            }

            String response = "Hello client, you sent: " + request;
            dataOutputStream.writeUTF(response);
            System.out.println("Sent response: " + response);

            dataOutputStream.close();
            dataInputStream.close();
            socket.close();
        }

        serverSocket.close();
        System.out.println("Server closed");
    }
}
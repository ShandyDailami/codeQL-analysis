import java.io.*;
import java.net.*;

public class java_03794_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                // Reading request from client
                String request = dataInputStream.readUTF();
                System.out.println("Received request: " + request);

                // Sending response to client
                String response = "Hello, client";
                dataOutputStream.writeUTF(response);
                System.out.println("Sent response: " + response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
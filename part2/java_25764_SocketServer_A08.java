import java.net.*;
import java.io.*;

public class java_25764_SocketServer_A08 {
    private static final String PORT_NUMBER = "4445"; // Use a port number that is not in use

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(Integer.parseInt(PORT_NUMBER)));

            System.out.println("Server started...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected...");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String clientMessage = dataInputStream.readUTF();
                System.out.println("Received from client: " + clientMessage);

                String serverMessage = "Hello, client!";
                dataOutputStream.writeUTF(serverMessage);
                System.out.println("Server replied: " + serverMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
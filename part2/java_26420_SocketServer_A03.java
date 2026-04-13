import java.io.*;
import java.net.*;

public class java_26420_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            while (true) {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected on port " + socket.getLocalPort());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String clientMessage = in.readUTF();
                System.out.println("Received client message: " + clientMessage);
                String serverMessage = "Hello, client, your message was: " + clientMessage;
                out.writeUTF(serverMessage);
                out.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
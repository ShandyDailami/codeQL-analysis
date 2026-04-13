import java.io.*;
import java.net.*;

public class java_24464_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Waiting for client connection...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientMessage;
            while ((clientMessage = input.readUTF()) != null) {
                System.out.println("Received: " + clientMessage);
                if (clientMessage.equals("close")) {
                    break;
                }
                output.writeUTF("Server received your message: " + clientMessage);
           
            }

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
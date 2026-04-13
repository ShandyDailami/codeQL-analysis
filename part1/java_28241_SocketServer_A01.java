import java.io.*;
import java.net.*;

public class java_28241_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Server started at port 8189");

            Socket socket = serverSocket.accept();
            System.out.println("A new client has connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientMessage;

            while ((clientMessage = input.readUTF()) != null) {
                System.out.println("Received: " + clientMessage);

                if (clientMessage.equalsIgnoreCase("exit")) {
                    System.out.println("Client has disconnected");
                    break;
                } else {
                    System.out.println("Sending: " + clientMessage);
                    output.writeUTF(clientMessage);
                    output.flush();
                }
            }

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
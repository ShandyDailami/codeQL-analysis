import java.net.*;
import java.io.*;

public class java_21117_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String clientMessage = dis.readUTF();
                System.out.println("Received message: " + clientMessage);

                if ("auth".equals(clientMessage)) {
                    String authResponse = "OK";
                    dos.writeUTF(authResponse);
                } else {
                    String response = "Hello, client!";
                    dos.writeUTF(response);
                }

                dos.flush();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.io.*;
import java.net.*;

public class java_07515_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server started at port: " + 8080);

            while(true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String clientMessage = dis.readUTF();
                System.out.println("Received from client: " + clientMessage);

                // Assume clientMessage contains a password for authentication
                if(clientMessage.equals("securePassword")) {
                    dos.writeUTF("Authentication successful!");
                    dos.flush();
                } else {
                    dos.writeUTF("Wrong password!");
                    dos.flush();
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
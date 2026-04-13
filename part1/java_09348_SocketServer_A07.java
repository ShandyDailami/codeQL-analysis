import java.io.*;
import java.net.*;

public class java_09348_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444...");

            while(true) {
                Socket socket = server.accept();
                System.out.println("A client has connected...");

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String clientMessage = input.readUTF();
                System.out.println("Received: " + clientMessage);

                String serverMessage = "Hello, client!";
                output.writeUTF(serverMessage);
                System.out.println("Sent: " + serverMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.io.*;
import java.net.*;

public class java_00718_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected");

                // Create input and output streams
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Read the message from the client
                String message = dis.readUTF();
                System.out.println("Client says: " + message);

                // Send a response back to the client
                String response = "Hello client, your message was received!";
                dos.writeUTF(response);
                System.out.println("Server says: " + response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
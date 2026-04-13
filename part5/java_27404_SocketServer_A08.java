import java.io.*;
import java.net.*;

public class java_27404_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                Socket socket = serverSocket.accept();

                // Receive message from client
                DataInputStream input = new DataInputStream(socket.getInputStream());
                String message = input.readUTF();
                System.out.println("Received: " + message);

                // Send message back to client
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                output.writeUTF("Hello, client. You wrote: " + message);
                output.flush();

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
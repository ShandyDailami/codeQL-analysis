import java.io.*;
import java.net.*;

public class java_11644_SocketServer_A03 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create input and output streams
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Receive message from client
                String message = dis.readUTF();
                System.out.println("Received: " + message);

                // Send response back to client
                dos.writeUTF("Server received your message: " + message);
                dos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
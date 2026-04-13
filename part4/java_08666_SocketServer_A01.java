import java.io.*;
import java.net.*;

public class java_08666_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 1234; //define your port
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create input stream and output stream
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Reading from client
                String message = dis.readUTF();
                System.out.println("Client says: " + message);

                // Sending reply
                dos.writeUTF("Server says: Message received");
                dos.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
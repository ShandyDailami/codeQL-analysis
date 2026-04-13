import java.io.*;
import java.net.*;

public class java_40560_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client connected!");

                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                String message = inputStream.readUTF();
                System.out.println("Received message: " + message);

                String response = "Server received your message: " + message;
                outputStream.writeUTF(response);
                outputStream.close();
           
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
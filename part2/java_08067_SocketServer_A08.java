import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class java_08067_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        // Step 1: Initialize ServerSocket
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started. Waiting for client...");

        while (true) {
            // Step 2: Accept client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Step 3: Communication with the client
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            int bytes = 0;
            byte[] buffer = new byte[1024];

            // Receive data from client
            while ((bytes = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytes);
            }

            // Step 4: Close connection
            socket.close();
        }
    }
}
import java.io.*;
import java.net.*;

public class java_13873_SocketServer_A08 {
    public static void main(String[] args) {
        // Create a server socket
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server started on port 8080");

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new thread to handle communication with the client
                new SocketServerThread(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketServerThread extends Thread {
    private final Socket socket;

    public java_13873_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (OutputStream out = socket.getOutputStream();
             InputStream in = socket.getInputStream()) {

            byte[] request = new byte[1024];
            int bytesRead = in.read(request);

            if (bytesRead < 0) {
                System.out.println("Client disconnected");
                return;
            }

            byte[] response = "Hello, client!".getBytes();
            out.write(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
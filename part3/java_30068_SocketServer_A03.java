import java.io.*;
import java.net.*;

public class java_30068_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            // Fork a new thread for the client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    public java_30068_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Receive client's message
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Echo back to client
            out.println("Server: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
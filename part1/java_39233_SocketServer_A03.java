import java.io.*;
import java.net.*;

public class java_39233_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Create a new thread for handling each client
            HandleClientThread thread = new HandleClientThread(socket);
            thread.start();
        }
    }
}

class HandleClientThread extends Thread {
    private Socket socket;

    public java_39233_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Receive and respond to client's message
            String message = in.readLine();
            out.println("Server received: " + message);

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
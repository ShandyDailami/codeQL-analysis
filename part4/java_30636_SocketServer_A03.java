import java.io.*;
import java.net.*;

public class java_30636_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started on port 1234");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client connected");

                // Non-blocking way of handling client
                new HandleClientThread(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port 1234");
        }
    }
}

class HandleClientThread extends Thread {
    private Socket socket;

    public java_30636_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read a message from the client
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Handle the message, in this case, we'll just echo it back
            out.println("Echo: " + message);

            socket.close();
        } catch (IOException e) {
            System.out.println("Failed to handle client");
        }
    }
}
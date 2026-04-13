import java.net.*;
import java.io.*;

public class java_41345_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        while (true) {
            Socket socket = server.accept();

            // Create a new thread to handle the client request
            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_41345_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Verify the client's identity
            out.println("Enter your username:");
            String username = in.readLine();

            // Assume the client's username is correct
            out.println("Hello, " + username + ", you are authenticated!");

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
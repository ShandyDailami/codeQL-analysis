import java.net.*;
import java.io.*;

public class java_36982_SocketServer_A03 {
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Creating a new thread to handle the client
            new HandleClientThread(socket).start();
        }
    }
}

// This thread is dedicated to handle a single client
class HandleClientThread extends Thread {
    private Socket socket;

    public java_36982_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Creating input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Reading from the client
            String input;
            while ((input = in.readLine()) != null) {
                System.out.println("Received: " + input);
                // Sending a response back to the client
                out.println("Echo: " + input);
            }

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
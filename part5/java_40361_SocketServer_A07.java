import java.io.*;
import java.net.*;

public class java_40361_SocketServer_A07 {
    private static final int port = 1234;
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started at port: " + port);

            while(true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Create new thread to handle each client
                new EchoHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + port + " or creating server socket");
            e.printStackTrace();
        }
    }
}

class EchoHandler extends Thread {
    private Socket socket;
    public java_40361_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send a welcome message
            out.println("Welcome to the secure echo server");

            String message;
            while((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Echo: " + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
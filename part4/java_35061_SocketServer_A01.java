import java.net.*;
import java.io.*;

public class java_35061_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started on port 4444");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            // Create input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Check if client is trying to connect directly
            if (socket.getRemoteSocketAddress().toString().contains("localhost")) {
                out.println("Connection denied. Attempting to connect via proxy server.");
                out.flush();
                socket.close();
                continue;
            }

            // Check if client is trying to connect through an external proxy server
            if (!socket.getLocalAddress().toString().contains("localhost")) {
                out.println("Connection denied. Not connected through an external proxy server.");
                out.flush();
                socket.close();
                continue;
            }

            // If all checks pass, allow the connection
            out.println("Connection accepted.");
            out.flush();

            // Start a new thread to handle communication
            new Handler(socket, in, out).start();
        }
    }
}

class Handler extends Thread {
    Socket socket;
    BufferedReader in;
    PrintWriter out;

    public java_35061_SocketServer_A01(Socket socket, BufferedReader in, PrintWriter out) {
        this.socket = socket;
        this.in = in;
        this.out = out;
    }

    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // TODO: Add your own logic to process the message
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
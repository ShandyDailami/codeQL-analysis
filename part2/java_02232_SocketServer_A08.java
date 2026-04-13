import java.io.*;
import java.net.*;
import java.util.*;

public class java_02232_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create server socket
            serverSocket = new ServerSocket(5000);

            while (true) {
                System.out.println("Waiting for a connection...");

                // Accept a new client
                socket = serverSocket.accept();

                // Create new thread for each connection
                SocketThread thread = new SocketThread(socket);

                // Start the new thread
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the server socket
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class SocketThread extends Thread {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public java_02232_SocketServer_A08(Socket socket) {
        this.socket = socket;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message;
        try {
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);

                // Only allow connections from specific IP addresses
                if ("127.0.0.1".equals(socket.getRemoteSocketAddress().toString()) ||
                    "127.0.0.2".equals(socket.getRemoteSocketAddress().toString())) {

                    // Send a response
                    writer.println("Hello, you are connected to SocketServer!");
                    writer.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
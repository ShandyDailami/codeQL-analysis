import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_03954_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        try {
            serverSocket = new ServerSocket(4444);
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(4444);

            // Enable server to accept client connections
            sslServerSocket.setNeedClientAuthentication(true);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            try {
                Socket socket = sslServerSocket.accept();
                System.out.println("Client connected");

                // Create input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Send a welcome message
                out.writeBytes("Welcome to the server!\n".getBytes());

                // Create a new thread for the client
                new ClientHandler(socket, in, out).start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    private BufferedReader in;
    private DataOutputStream out;

    public java_03954_SocketServer_A01(Socket socket, BufferedReader in, DataOutputStream out) {
        this.socket = socket;
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        try {
            // Receive a message from the client
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Send a response to the client
            out.writeBytes("Hello from the server!\n".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
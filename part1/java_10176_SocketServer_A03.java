import java.io.*;
import java.net.*;
import java.util.*;

// Thread for handling each client connection
class java_10176_SocketServer_A03 extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public SecureSocketServer(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            // handle exception
        }
    }

    public void run() {
        String message;
        try {
            // read in client's message and print
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // send message back to client
                out.println("Server says: " + message);
            }
        } catch (IOException e) {
            // handle exception
        }
    }
}

// Socket Server
public class SecureSocketServer {
    private ServerSocket server;

    public SecureSocketServer(int port) {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            // handle exception
        }
    }

    public void startServer() {
        System.out.println("Server started on port: " + server.getLocalPort() + "...");
        while (true) {
            try {
                Socket client = server.accept();
                System.out.println("Accepted a new connection from: " + client.getRemoteSocketAddress());
                // create a new thread to handle the client
                new ClientHandler(client).start();
            } catch (IOException e) {
                // handle exception
                System.out.println("Error occurred while accepting client connection.");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer(4445).startServer();
    }
}
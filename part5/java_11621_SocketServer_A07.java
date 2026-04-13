import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11621_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT, 0, InetAddress.getByName("localhost"));
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");
                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to bind on port " + PORT);
            System.exit(-1);
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_11621_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here you can implement your authentication process
            // For example, you can use a pre-defined username and password
            if ("username".equals(socket.getRemoteSocketAddress().toString()) && "password".equals("password")) {
                // If authentication is successful, you can send a response to the client
                socket.getOutputStream().write("Authentication successful".getBytes());
            } else {
                socket.getOutputStream().write("Authentication failed".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the socket connection
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
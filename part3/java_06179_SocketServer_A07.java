import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06179_SocketServer_A07 {

    public static void main(String[] args) {

        int port = 8080;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Start a new thread to handle the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {

    private Socket socket;

    public java_06179_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read the username and password from the client
            // For simplicity, we'll just use the client's IP address as a username and password
            String username = socket.getRemoteSocketAddress().toString();
            String password = socket.getInputStream().readUTF();

            // Check the username and password
            if ("username".equals(username) && "password".equals(password)) {
                System.out.println("Authentication successful!");
            } else {
                System.out.println("Authentication failed!");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
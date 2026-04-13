import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21075_SocketServer_A07 {
    private int port;

    public java_21075_SocketServer_A07(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started at port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Start a new thread to handle the communication with the client
            new SocketHandler(socket).start();
        }
    }

    public static void main(String[] args) throws IOException {
        new SocketServer(1234).start();
    }
}

class SocketHandler extends Thread {
    private Socket socket;

    public java_21075_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Authentication logic
        new AuthServer(socket).start();
    }
}

class AuthServer extends Thread {
    private Socket socket;

    public java_21075_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Assume the client sends a username and password
        // Here, we're using a simple authentication mechanism:
        // If the password is "password", the username is accepted.
        // If not, an AuthFailure exception is thrown.

        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            String username = (String) in.readObject();
            String password = (String) in.readObject();

            if ("password".equals(password)) {
                System.out.println("User " + username + " authenticated.");
                // If password is correct, start communication with the client
                new ClientCommunication(socket).start();
            } else {
                throw new AuthFailureException("Authentication failed");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

class ClientCommunication extends Thread {
    private Socket socket;

    public java_21075_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Send a message to the client
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject("Hello, client!");
            out.flush();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
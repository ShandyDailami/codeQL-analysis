import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35534_SocketServer_A03 {

    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started at port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Create a new thread to handle the communication
            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
       
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_35534_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here, we are demonstrating the injection of SQL injection, 
            // a common attack technique where an attacker could manipulate the SQL query sent to the server.
            String injection = "SELECT * FROM users WHERE username='" + socket.getRemoteSocketAddress() + "' AND password='" + socket.getRemoteSocketAddress() + "'";

            // This is a SELECT query, so the injection should be validated at the database level.

            // Send a message back to the client
            socket.getOutputStream().write("Hello, client".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
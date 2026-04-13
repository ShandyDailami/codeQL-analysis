import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21204_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            // Set the port number
            int portNumber = 8080;

            // Create a new ServerSocket
            ServerSocket serverSocket = new ServerSocket(portNumber);

            System.out.println("Server is listening on port " + portNumber);

            // Keep the server running forever
            while (true) {
                // Accept a new client
                Socket socket = serverSocket.accept();

                // Create a new thread for the client
                Thread thread = new Thread(new ClientHandler(socket));

                // Start the thread
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;

    public java_21204_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client
        // ...
    }
}
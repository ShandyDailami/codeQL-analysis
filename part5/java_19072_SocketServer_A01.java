import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19072_SocketServer_A01 {

    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected.");

                // Handling the client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Server encountered an error. It will now shut down. " + e);
            e.printStackTrace();
       
            // Close the listener and exit the application
            System.exit(-1);
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_19072_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: handle client request
        // This is a simplistic example, in a real-world application you would likely want to handle the client request in a more complex way
        try {
            // TODO: Send a response to the client
            // This is also a simplistic example
            socket.getOutputStream().write("Hello, Client!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        socket.close();
    }
}
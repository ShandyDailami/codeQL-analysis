import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07423_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000); // Listening port
            System.out.println("Server started at port 5000.");

            while (true) {
                Socket socket = server.accept(); // Waiting for client
                System.out.println("Client connected.");

                // Creating a new thread for each client
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
            // Shutdown the server
            try {
                server.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_07423_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Reading the message from the client
            String message = socket.getInputStream().readUTF();
            System.out.println("Received message: " + message);

            // Sending a message back to the client
            socket.getOutputStream().writeUTF("Message received.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
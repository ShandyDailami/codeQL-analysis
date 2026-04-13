import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02998_SocketServer_A03 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new thread for each client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_02998_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Handle client input and output
            // For the sake of simplicity, we're only accepting user inputs and sending back the same message
            while (true) {
                String message = socket.getInputStream().readUTF();
                System.out.println("Received: " + message);

                String response = "Message received: " + message;
                socket.getOutputStream().writeUTF(response);
                socket.getOutputStream().flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
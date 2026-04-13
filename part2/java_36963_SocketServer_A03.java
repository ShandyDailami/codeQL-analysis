import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36963_SocketServer_A03 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client is connected");

                // Start a new thread to handle the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_36963_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Assume that a client has sent a string
            String message = socket.getInputStream().readUTF();
            System.out.println("Received: " + message);

            // Now we assume that the client wants to send a response back to us
            String response = "Hello, client!";
            socket.getOutputStream().writeUTF(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
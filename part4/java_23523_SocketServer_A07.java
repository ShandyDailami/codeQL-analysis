import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23523_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port: " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getInetAddress() + " connected");

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_23523_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here you can add code to handle client's request.
            // This is just a placeholder, you should implement your authentication logic here.

            // Example of a simple authentication
            String clientRequest = socket.getInputStream().readUTF();
            if (clientRequest.equals("auth")) {
                socket.getOutputStream().writeUTF("authSuccess");
            } else {
                socket.getOutputStream().writeUTF("authFailure");
            }

            // Always remember to close the socket after the task is completed
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
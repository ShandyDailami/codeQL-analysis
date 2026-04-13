import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19478_SocketServer_A01 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Handle client connection, e.g., start thread for each client
                new HandleClient(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandleClient extends Thread {
    private Socket socket;

    public java_19478_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client's request or response here
        // For example, read from and write to client

        // Here's a simple example: read a string from the client and print it
        try {
            String message = socket.getInputStream().readUTF();
            System.out.println("Received: " + message);

            String response = "Hello, " + message;
            socket.getOutputStream().writeUTF(response);
            socket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the socket
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
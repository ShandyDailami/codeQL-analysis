import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26581_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Perform security sensitive operations related to A01_BrokenAccessControl here
                // This example doesn't perform any operations, but it is a starting point

                // Now start a new thread to handle the communication with the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to listen on port 12345");
       
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_26581_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Handle client communication here
        // This example doesn't handle communication, but it is a starting point
    }
}
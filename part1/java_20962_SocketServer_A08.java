import java.net.ServerSocket;
import java.net.Socket;

public class java_20962_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // Binding to port 8080
            System.out.println("Server is listening on port 8080...");
            
            while (true) {
                Socket clientSocket = serverSocket.accept(); // Waiting for client connection
                System.out.println("Client connected!");
                
                // Handle client connection in separate thread
                new ClientHandler(clientSocket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;
    
    public java_20962_SocketServer_A08(Socket socket) {
        this.clientSocket = socket;
    }
    
    @Override
    public void run() {
        // Code to handle client communication goes here
        // ...
    }
}
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35344_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234); // Listen on port 1234
            System.out.println("Server started on port 1234. Waiting for client connections...");
            
            while(true) {
                Socket clientSocket = serverSocket.accept(); // Wait for a client connection
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());
                
                // Handle the client connection in a new thread
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    
    public java_35344_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }
    
    public void run() {
        try {
            // Read a message from the client
            byte[] bytes = new byte[1024];
            socket.getInputStream().read(bytes);
            String message = new String(bytes);
            
            // Handle the message
            System.out.println("Received message: " + message);
            
            // Send a response
            String response = "Server received your message: " + message;
            socket.getOutputStream().write(response.getBytes());
            
            socket.getOutputStream().close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
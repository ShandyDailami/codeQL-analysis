import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10271_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080, 10000, InetAddress.getByName("127.0.0.1"));
            System.out.println("Server started on port 8080");
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getInetAddress().getHostAddress());
                
                // Start a new thread for each client
                new ClientHandler(clientSocket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;
    
    public java_10271_SocketServer_A08(Socket socket) {
        this.clientSocket = socket;
    }
    
    @Override
    public void run() {
        try {
            // Receive message from client
            String message = new java.util.Scanner(clientSocket.getInputStream()).nextLine();
            System.out.println("Received: " + message);
            
            // Send response to client
            clientSocket.getOutputStream().write((("Server received: " + message).getBytes()));
            clientSocket.getOutputStream().flush();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import java.net.ServerSocket;
import java.net.Socket;

public class java_04719_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000); // port number
            System.out.println("Waiting for client...");
            
            Socket clientSocket = server.accept(); // blocks until client connects
            System.out.println("Connected");
            
            // Handle the client socket...
            // This is where you'd add your code to handle client communication
            
            // Close the client socket and the server socket
            clientSocket.close();
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
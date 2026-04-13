import java.net.Socket;
import java.net.ServerSocket;

public class java_36837_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234); // Port number
            System.out.println("Server started on port 1234");
            
            while(true) {
                Socket socket = serverSocket.accept(); // Wait for a client
                System.out.println("New client connected");
                
                // Now, handle the client connection...
                // For now, we'll just send a message back to the client
                socket.getOutputStream().write("Hello, client!".getBytes());
                socket.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
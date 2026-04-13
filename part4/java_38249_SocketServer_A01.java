import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38249_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234); // open a port
            System.out.println("Waiting for client...");
            
            Socket socket = server.accept(); // wait for client connection
            System.out.println("Connected!");
            
            // here goes the real logic of your server. For example, handling received data.
            // for simplicity, let's print received message
            byte[] bytes = new byte[1024];
            socket.getInputStream().read(bytes, 0, 1024);
            System.out.println("Received: " + new String(bytes));
            
            socket.getOutputStream().write("Hello Client".getBytes());
            System.out.println("Sent: Hello Client");
            
            socket.close();
            server.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
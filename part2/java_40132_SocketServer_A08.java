import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40132_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");
            
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");
                
                // Here, you would typically handle the client and perform security-sensitive operations.
                // However, since this is a placeholder for A08_IntegrityFailure, we'll just echo back the data.
                // This is a place holder as security operations are typically more complex.
                byte[] bytes = new byte[1024];
                socket.getInputStream().read(bytes);
                socket.getOutputStream().write(bytes);
           
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.net.ServerSocket;
import java.net.Socket;

public class java_23762_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            // Create a server socket and listen on port 1234
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234...");

            // Accept incoming connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected...");

            // Here is where you would normally handle the client connection
            // However, since this is a simple server, we'll just echo back any received data
            while ((socket.getInputStream().read()) != -1) ;

            // Close the socket and exit
            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import java.net.ServerSocket;
import java.net.Socket;

public class java_32299_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            while (true) {
                Socket socket = server.accept();
                System.out.println("A client is connected!");

                // Here you should implement a protocol to handle communication between client and server.
                // For simplicity, this example simply closes the connection.
                socket.close();
           
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
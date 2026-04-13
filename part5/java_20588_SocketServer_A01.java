import java.net.ServerSocket;
import java.net.Socket;

public class java_20588_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client is connected");

                // Here, we're not actually serving any data. 
                // Instead, we're demonstrating the principle of Broken Access Control by accepting connections and then closing the connection
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
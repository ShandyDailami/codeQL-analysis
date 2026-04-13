import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41734_SocketServer_A01 {

    private int port;
    private ServerSocket serverSocket;

    public java_41734_SocketServer_A01(int port) {
        this.port = port;
        startServer();
    }

    private void startServer() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                // Handle client connection here

            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new SocketServer(1234);
    }
}
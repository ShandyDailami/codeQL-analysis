import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12736_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                // Use a separate thread for each connection
                new Thread(new SocketHandler(socket)).start();
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
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_12736_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the connection here
        // This is just a placeholder, you will need to implement the actual handling
    }
}
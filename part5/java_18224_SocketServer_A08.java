import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18224_SocketServer_A08 {
    private int port;

    public java_18224_SocketServer_A08(int port) {
        this.port = port;
    }

    public void start() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is running on port: " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());
                // Start handling the client here
                new Handler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SocketServer(8080).start();
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_18224_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Handle the client connection here, for example:
        // socket.getInputStream().read();
        // socket.getOutputStream().write();
    }
}
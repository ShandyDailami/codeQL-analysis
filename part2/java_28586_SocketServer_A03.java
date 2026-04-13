import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28586_SocketServer_A03 {
    private int port;

    public java_28586_SocketServer_A03(int port) {
        this.port = port;
    }

    public void start() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected " + socket.getRemoteSocketAddress());

                // Here, you can perform operations that are safe from A03_Injection
                // for instance, the operation could be to execute commands on the client's machine

                // For simplicity, let's just echo back the message from the client
                byte[] bytes = socket.getInputStream().readAllBytes();
                socket.getOutputStream().write(bytes);
                socket.getOutputStream().flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null && !serverSocket.isClosed()) {
                    serverSocket.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SocketServer(9090).start();
    }
}
import java.net.ServerSocket;
import java.net.Socket;

public class java_05898_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // Create a ServerSocket and wait for connections
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is running and waiting for connections...");

            while (true) {
                // Accept a new connection
                Socket socket = server.accept();
                System.out.println("A connection has been established with " + socket.getRemoteSocketAddress());

                // Handle the connection in a separate thread
                new ClientHandler(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_05898_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Handle the connection
            // Here we just echo the incoming message back to the client
            while ((socket.getInputStream().read()) != -1) ;
            socket.getOutputStream().write("Hello Client!".getBytes());
            socket.getOutputStream().flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
}
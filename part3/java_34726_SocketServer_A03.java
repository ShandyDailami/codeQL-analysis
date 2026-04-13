import java.net.ServerSocket;
import java.net.Socket;

public class java_34726_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("A client connected");

                // Start a new thread to handle communication with the client
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_34726_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get the input and output streams
            socket.getInputStream();
            socket.getOutputStream();

            // TODO: Handle client communication securely (e.g., prevent SQL injection)

            System.out.println("Handshake done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
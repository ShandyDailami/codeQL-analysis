import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12576_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

                // Create a new thread to handle the client request
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;

    public java_12576_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Handle the client request here

        // Close the socket
        try {
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
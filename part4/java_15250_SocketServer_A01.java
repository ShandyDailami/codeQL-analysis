import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15250_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // create a new ServerSocket
            ServerSocket serverSocket = new ServerSocket(50001, 0, InetAddress.getByName("localhost"));
            System.out.println("Server started on port 50001");

            while (true) {
                // accept a new client
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // create a new thread for the client
                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_15250_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // handle the client
        // for now, just print the client's IP address
        try {
            System.out.println("Client IP: " + socket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
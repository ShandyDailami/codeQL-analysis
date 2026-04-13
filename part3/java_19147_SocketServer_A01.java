import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19147_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444); // port number
            System.out.println("Server is listening on port 4444");

            while (true) {
                Socket socket = server.accept();
                System.out.println("A new client has connected");

                // handle client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_19147_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // handle client communication
        // ...
    }
}
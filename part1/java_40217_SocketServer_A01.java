import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40217_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000); // Port 5000 is arbitrary
            System.out.println("Server started on port 5000");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                // Handle the socket here
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_40217_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the socket here, for example, by reading and writing
        try {
            // Read from the socket
            // Write to the socket
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
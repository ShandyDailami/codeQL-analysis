import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06601_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Perform integrity checks for A08_IntegrityFailure
                // ...

                // Handle the socket in a separate thread
                new HandleSocketThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandleSocketThread extends Thread {
    private Socket socket;

    public java_06601_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // ...
        // Code to handle the socket and perform A08_IntegrityFailure checks
        // ...
        // ...

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
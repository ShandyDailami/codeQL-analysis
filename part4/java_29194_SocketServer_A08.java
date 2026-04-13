import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29194_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a ServerSocket on port 12345
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started at port 12345.");

            while (true) {
                // Accept a new connection
                Socket socket = serverSocket.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                // Handle the connection in a new thread
                new SocketHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            try {
                // Close the ServerSocket
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class SocketHandler extends Thread {
    private Socket socket;

    public java_29194_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Here you can add the code to handle the connection and protect it
        // from being intercepted. This could include things like checking
        // the integrity of the data being sent and received.

        // For now, we just print out the remote socket address
        System.out.println("Remote Socket Address: " + socket.getRemoteSocketAddress());
    }
}
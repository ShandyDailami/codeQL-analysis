import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39530_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 4445; // port number to bind the server to

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Start a new thread to handle the communication
                new Handler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port " + port);
            System.exit(1);
        }
    }

    static class Handler extends Thread {
        Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            // Handle communication with the client here
            // This is a simple example, not a full-featured server
            try {
                while (true) {
                    byte[] buffer = new byte[1024];
                    int bytesRead = socket.getInputStream().read(buffer);
                    if (bytesRead == -1) {
                        break;
                    }
                    // Here you could add more security measures like encryption or more complex validation
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
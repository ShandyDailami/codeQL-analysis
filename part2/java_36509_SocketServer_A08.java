import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36509_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Here, we create a new thread for each client connection.
            // This is a very simple example and not recommended for a production environment.
            // In a real-world scenario, you would want to use a thread pool and a message queue to handle multiple clients at once.
            new Handler(socket).start();
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_36509_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Here, we simulate a security-sensitive operation that involves checking the integrity of the data being sent.
        // In a real-world scenario, you would want to use a secure protocol (like TLS) and use a cryptographic library.
        // This is a simplistic example and not recommended for a production environment.
        try {
            while (true) {
                byte[] buffer = new byte[1024];
                socket.getInputStream().read(buffer);

                // Here, we check if the data contains any bogus bytes.
                // This is a very simple example and not recommended for a production environment.
                // In a real-world scenario, you would want to use a checksum or other form of authentication.
                for (byte b : buffer) {
                    if ((b & 0xFF) == 0x00) {
                        System.out.println("Integrity failure detected!");
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
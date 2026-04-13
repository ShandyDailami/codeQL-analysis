import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08845_SocketServer_A08 {
    public static void main(String[] args) {
        Socket socket;
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(5200); // Port 5200 is arbitrary
            System.out.println("Waiting for client on port 5200...");

            while ((socket = serverSocket.accept()) != null) {
                new Thread(new SocketServerHandler(socket)).start();
            }

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketServerHandler implements Runnable {
    private Socket socket;

    public java_08845_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Setup SSL for client communication
            SSLServerSocket sslServerSocket = new SSLServerSocket(socket);
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

            // SSLHandshake to establish the SSL connection
            sslSocket.startHandshake();

            // Verify if the client is SSL-encrypted
            if (sslSocket.isClientHelloSupported()) {
                System.out.println("Client is SSL-encrypted");

                // Read from SSL socket
                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("Received: " + line);
                }

                sslSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
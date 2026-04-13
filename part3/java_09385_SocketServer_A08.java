import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09385_SocketServer_A08 {
    private ServerSocket serverSocket;

    public java_09385_SocketServer_A08(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startServer() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new client at: " + clientSocket.getRemoteSocketAddress());

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;
        private OutputStream out;

        public java_09385_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = clientSocket.getOutputStream();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.write(message.length() + "\n".getBytes()); // Send the length of the received message back to the client
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SocketServer(8080).startServer();
    }
}
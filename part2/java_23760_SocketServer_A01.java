import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23760_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on port 8080");
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_23760_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                java.io.InputStream input = socket.getInputStream();
                java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(input));

                String message = br.readLine();
                System.out.println("Received: " + message);

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            System.err.println("Error occurred while reading from or writing to the socket");
            e.printStackTrace();
        }
    }
}
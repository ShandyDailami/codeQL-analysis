import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13402_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // handle client connection here
                // you can create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_13402_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client communication here
        // for example, read a message from the client and print it
        // then send a response back to the client
        // you can use InputStreamReader and BufferedReader for reading client messages
        // you can use OutputStreamWriter and PrintWriter for sending messages back to the client
    }
}
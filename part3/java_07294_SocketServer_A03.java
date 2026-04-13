import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07294_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client is connected");

            // handle client connection here
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_07294_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // read the request from the client
            // process the request and send the response back
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
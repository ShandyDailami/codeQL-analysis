import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29974_SocketServer_A08 {
    private static final int PORT = 8080; // the port the server will listen on

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT); // create a server socket
            System.out.println("Server is listening on port " + PORT + "...");

            while (true) {
                Socket socket = serverSocket.accept(); // accept a client socket
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // handle the client socket in a new thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_29974_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: implement the client handling
            // for now, we will just print the client's address
            System.out.println("Client's address is " + socket.getRemoteSocketAddress());
        }
    }
}
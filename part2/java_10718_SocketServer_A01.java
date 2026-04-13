import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10718_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // create a server socket
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server is listening on port 8080");

        while (true) {
            // accept a client connection
            Socket socket = serverSocket.accept();

            System.out.println("A client has connected");

            // create a new thread for each client connection
            ClientHandler clientHandler = new ClientHandler(socket);
            clientHandler.start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_10718_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // handle the client connection
        // for now, just print a message
        System.out.println("Client handler started");

        // close the socket after handling the client connection
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
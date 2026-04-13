import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12582_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // listen on port 8080
        while (true) {
            Socket client = server.accept(); // accept a client connection
            System.out.println("Client connected: " + client.getRemoteSocketAddress());

            // start a new thread to handle communication with the client
            new Thread(new SocketHandler(client)).start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_12582_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // here you can handle the communication with the client
            // for example, read from the socket and write to the client
            // ...

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33473_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // create a new thread for each client
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_33473_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // handle the client connection here
        // this is a simplistic example, a real-world application would need to handle multiple clients,
        // use a thread pool, handle multiple types of connections, etc.

        try {
            // read the request from the client
            // this is a simplistic example, a real-world application would need to implement proper protocol,
            // handle exceptions, etc.
            String request = socket.getInputStream().readUTF();
            System.out.println("Received: " + request);

            // send a response back to the client
            // this is a simplistic example, a real-world application would need to use secure protocols,
            // handle exceptions, etc.
            String response = "Hello, client!";
            socket.getOutputStream().writeUTF(response);
            socket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18159_SocketServer_A03 {
    private static final int PORT = 4445; // the port to listen on

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT); // create a server socket
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = server.accept(); // accept a client socket
                System.out.println("A client has connected.");

                // handle the client in a separate thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_18159_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // read a message from the client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String message = new String(buffer, 0, buffer.length);
            System.out.println("Received: " + message);

            // send a response back to the client
            String response = "Hello, client!";
            socket.getOutputStream().write(response.getBytes());
            System.out.println("Sent: " + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
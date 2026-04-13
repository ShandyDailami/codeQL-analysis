import java.io.*;
import java.net.*;

public class java_41579_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        int port = 12345;
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server is listening on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Client connected");

            // start a new thread to handle the client request
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_41579_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream input = socket.getInputStream();
             OutputStream output = socket.getOutputStream()) {

            // read request
            DataInputStream in = new DataInputStream(input);
            DataOutputStream out = new DataOutputStream(output);

            String request = in.readUTF();
            System.out.println("Received request: " + request);

            // handle the request
            if ("stop".equals(request)) {
                System.out.println("Server stopped");
                socket.close();
            } else {
                System.out.println("Unknown request: " + request);
            }

            out.writeUTF("OK");
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
    }
}
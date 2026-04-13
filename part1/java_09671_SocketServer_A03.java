import java.io.*;
import java.net.*;

public class java_09671_SocketServer_A03 {
    private static final String SERVER_MESSAGE = "Hello, Client!";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started at port 8000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Split the thread into two for receiving messages from client
            Thread t = new Thread(new SocketHandler(socket));
            t.start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_09671_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            writer.println(SERVER_MESSAGE);

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Client: " + clientMessage);
                System.out.println("Server: " + SERVER_MESSAGE);

                writer.println(SERVER_MESSAGE);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
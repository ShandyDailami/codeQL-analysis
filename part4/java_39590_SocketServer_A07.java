import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39590_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started on port 1234");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Here, we'll create a new thread for each client.
            // Note: You could also use a thread pool for better performance.
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_39590_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here, we'll read the request from the client and print it.
            // For the purpose of this example, let's assume the request is a simple message.
            // In a real-world application, you'd probably read in a full request, handle it securely,
            // and then send a response back.
            String request = new java.util.Scanner(socket.getInputStream()).nextLine();
            System.out.println("Received: " + request);

            // Here, we'll write the response back to the client.
            // For the purpose of this example, let's just write a simple message.
            // In a real-world application, you'd probably write a more complex response.
            String response = "Hello, client!";
            socket.getOutputStream().write((response + "\n").getBytes());
            socket.getOutputStream().flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
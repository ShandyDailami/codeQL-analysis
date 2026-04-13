import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00630_SocketServer_A01 {

    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Here you can implement security-sensitive operations related to A01_BrokenAccessControl
            // For example, verify if the client is authorized to access the server
            // If not, reject the connection and send a response

            // For the sake of simplicity, this code will just accept the connection and do nothing with it
            // In a real-world scenario, you'd probably want to handle the connection in a separate thread
            new Thread(() -> {
                try {
                    // Here you can implement your server's logic here
                    // For example, you could handle text-based messages or binary data
                    // In a real-world scenario, you'd want to use a BufferedReader and BufferedWriter
                    // to handle both text-based and binary-based data

                    // For the sake of simplicity, this code will just simply print the data received from the client
                    // In a real-world scenario, you'd probably want to handle the received data in a separate thread
                    new Thread(() -> {
                        try (Socket clientSocket = socket;
                             java.io.BufferedReader in = new java.io.BufferedReader(
                                     new java.io.InputStreamReader(clientSocket.getInputStream()));
                             java.io.PrintWriter out = new java.io.PrintWriter(clientSocket.getOutputStream(), true)) {

                            String message;
                            while ((message = in.readLine()) != null) {
                                System.out.println("Received: " + message);
                                // Here you can add your server's logic to handle received data
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
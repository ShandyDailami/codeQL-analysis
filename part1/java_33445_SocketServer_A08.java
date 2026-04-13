import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33445_SocketServer_A08 {
    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected.");

            new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                    String message;
                    while ((message = reader.readLine()) != null) {
                        System.out.println("Received message: " + message);
                        writer.println("Server received: " + message);
                    }

                    socket.close();
                    System.out.println("Client disconnected.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
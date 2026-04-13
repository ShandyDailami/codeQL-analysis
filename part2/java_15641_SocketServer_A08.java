import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class java_15641_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                // Get the input and output streams
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                Scanner in = new Scanner(socket.getInputStream());

                // Read the client's message
                if (in.hasNextLine()) {
                    String message = in.nextLine();
                    System.out.println("Received: " + message);

                    // Send the received message back to the client
                    out.println(message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
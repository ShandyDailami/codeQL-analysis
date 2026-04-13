import java.net.*;
import java.io.*;

public class java_18008_SocketServer_A08 {
    public static void main(String args[]) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(6000); // set port
            System.out.println("Waiting for client...");

            while (true) {
                socket = server.accept();
                System.out.println("Client connected");

                // Start a new thread for each client
                new Thread(() -> handleClient(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       .
        } finally {
            try {
                if (server != null) server.close();
                if (socket != null) socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void handleClient(Socket socket) {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message, response;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // This is a simple echo server.
                // You can replace this with your own logic.
                response = "Echo: " + message;
                out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
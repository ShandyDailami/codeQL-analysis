import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13315_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234); // Server listening on port 1234
            System.out.println("Server started on port 1234");

            while (true) {
                Socket socket = serverSocket.accept(); // Waits for a client to connect
                System.out.println("New client connected");

                // Creates streams for reading and writing
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Reads the client message
                String message = in.readLine();
                System.out.println("Received: " + message);

                // Simulates authentication failure
                if ("failure".equals(message)) {
                    out.println("Authentication failed");
                } else {
                    out.println("Authentication succeeded");
                }

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
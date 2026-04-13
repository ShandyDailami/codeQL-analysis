import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15015_SocketServer_A01 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Here you can implement any security-sensitive operations related to A01_BrokenAccessControl
                    // For instance, checking if the message is a command to shut down the server or not.
                    // If it's a command, we respond accordingly.
                    if (message.equals("/shutdown")) {
                        out.println("Server shutting down...");
                        socket.close();
                        server.close();
                    }
                    else {
                        out.println("Unknown command. Only /shutdown is accepted.");
                    }
                }
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
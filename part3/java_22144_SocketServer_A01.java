import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_22144_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 5000; // default port

        if (args.length == 1) {
            port = Integer.parseInt(args[0]);
        }

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                try (Socket clientSocket = server.accept()) {
                    System.out.println("Accepted new client from " + clientSocket.getRemoteSocketAddress());

                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                        String message;
                        while ((message = reader.readLine()) != null) {
                            System.out.println("Received: " + message);
                            // send a response back to the client
                            try (PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {
                                writer.println("Thank you for connecting to " + clientSocket.getRemoteSocketAddress() + ". You wrote: " + message);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
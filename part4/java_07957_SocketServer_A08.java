import java.io.*;
import java.net.*;

public class java_07957_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                try (Socket clientSocket = server.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    System.out.println("New connection from " + clientSocket.getRemoteSocketAddress());

                    String request, response;
                    while ((request = in.readLine()) != null) {
                        System.out.println("Received: " + request);

                        // Security measure: A08_IntegrityFailure
                        if (request.equalsIgnoreCase("exit")) {
                            response = "Server shutting down";
                            out.println(response);
                            break;
                        } else {
                            response = "Hello, client!";
                        }

                        out.println(response);
                    }
                } catch (IOException e) {
                    System.out.println("Exception caught when trying to read from or write to " + clientSocket);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on " + PORT);
            e.printStackTrace();
        }
    }
}
import java.io.*;
import java.net.*;

public class java_27152_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 8080; // default port
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port);

            while (true) {
                try (Socket clientSocket = server.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    String request, response;
                    while ((request = in.readLine()) != null) {
                        System.out.println("Received: " + request);
                        response = request;
                        out.println(response);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Error with client connection: " + ex.getMessage());
        }
    }
}
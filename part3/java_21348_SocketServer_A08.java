import java.io.*;
import java.net.*;

public class java_21348_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 9876;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Received: " + message);
                        out.println("Echo: " + message);

                        // Check for integrity failure
                        if (message.length() > 1000) {
                            throw new RuntimeException("A08_IntegrityFailure: The message length is too large");
                        }
                    }
                } catch (IOException | RuntimeException e) {
                    e.printStackTrace();
                    System.out.println("Exception occured in I/O or integrity check");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
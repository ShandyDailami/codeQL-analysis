import java.io.*;
import java.net.*;

public class java_24388_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected from " + socket.getRemoteSocketAddress());

            // Here we handle the security-sensitive operations related to A08_IntegrityFailure
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);

                // Security-sensitive operation: Check if the received data matches a known pattern
                // In this case, we're checking if the input line is a simple numeric string
                if (inputLine.matches("\\d+")) {
                    System.out.println("Security violation detected: Received numeric string as input line");
                }
            }

            socket.close();
        }
    }
}
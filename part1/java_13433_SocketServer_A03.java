import java.io.*;
import java.net.*;

public class java_13433_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4242);
        while (true) {
            Socket socket = serverSocket.accept();
            handleRequest(socket);
        }
    }

    private static void handleRequest(Socket socket) {
        try (InputStream input = socket.getInputStream();
             OutputStream output = socket.getOutputStream()) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            DataOutputStream writer = new DataOutputStream(output);

            String request = reader.readLine();
            if (request != null) {
                // Handle the request, e.g., execute SQL injection, etc.
                // In real-world scenarios, these operations should be performed by a separate class or library.
                // This is just a simple example for A03_Injection
                // Assume the request is a simple SQL statement
                if (request.contains("DROP")) {
                    writer.write("You are not allowed to drop databases, sorry!".getBytes());
                } else if (request.contains("SELECT")) {
                    writer.write("You are not allowed to select tables, sorry!".getBytes());
                } else {
                    writer.write("Your request is processed successfully!".getBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
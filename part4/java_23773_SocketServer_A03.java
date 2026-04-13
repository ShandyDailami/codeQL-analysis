import java.io.*;
import java.net.*;

public class java_23773_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is listening on port 5000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client is connected");

            // Handle the client asynchronously
            new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                    String request;
                    while ((request = reader.readLine()) != null) {
                        System.out.println("Received: " + request);

                        // Here, you could also add security-related operations
                        // For instance, you might check for SQL injections or similar.

                        // For now, let's just send back the request
                        writer.write(("HTTP/1.1 200 OK\r\n\r\n" + request).getBytes());
                    }

                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
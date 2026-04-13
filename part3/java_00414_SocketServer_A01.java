import java.net.*;
import java.io.*;
import java.util.*;
import java.security.*;

public class java_00414_SocketServer_A01 {
    private static final String SERVER_SOCKET = "localhost";
    private static final int PORT = 5000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                DataOutputStream writer = new DataOutputStream(outputStream);

                String request = reader.readLine();
                System.out.println("Received request: " + request);

                // Here is where the Broken Access Control operation happens
                // For example, we'll check if the request contains a specific password
                if (request.equals("password")) {
                    System.out.println("Access denied for request: " + request);
                    writer.writeBytes("Access denied.\n");
                } else {
                    System.out.println("Access granted for request: " + request);
                    writer.writeBytes("Access granted.\n");
                }

                writer.flush();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
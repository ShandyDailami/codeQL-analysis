import java.io.*;
import java.net.*;

public class java_13954_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                // Read the request from the client
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request = reader.readLine();

                // Process the request (auth failure case)
                if (request.equals("AUTH_FAILURE")) {
                    // Send an auth failure response to the client
                    DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
                    writer.writeBytes("HTTP/1.1 401 Unauthorized\r\n\r\n");
                    writer.flush();
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
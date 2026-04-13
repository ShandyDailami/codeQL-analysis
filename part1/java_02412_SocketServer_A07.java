import java.io.*;
import java.net.*;

public class java_02412_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected...");

            // Perform authentication
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = reader.readLine();
            System.out.println("Received from client: " + clientMessage);

            // For simplicity, we'll just check if the client message is "admin"
            if ("admin".equals(clientMessage)) {
                outputStream.writeBytes("Access granted\n");
            } else {
                outputStream.writeBytes("Access denied\n");
            }

            outputStream.flush();
            socket.close();
        }
    }
}
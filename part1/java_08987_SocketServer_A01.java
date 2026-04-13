import java.io.*;
import java.net.*;

public class java_08987_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readLine();
            System.out.println("Received: " + clientMessage);

            if ("user1".equals(clientMessage)) {
                out.writeBytes("Access granted!\n");
            } else {
                out.writeBytes("Access denied!\n");
            }

            socket.close();
        }
    }
}
import java.io.*;
import java.net.*;

public class java_01187_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String clientMessage;
        while ((clientMessage = in.readLine()) != null) {
            System.out.println("Received: " + clientMessage);

            // Simulate authentication failure
            if (clientMessage.equals("fail")) {
                out.println("Auth failure!");
                out.close();
                in.close();
                socket.close();
                serverSocket.close();
            } else {
                out.println("Auth successful!");
                out.close();
                in.close();
                socket.close();
                serverSocket.close();
            }
        }
    }
}
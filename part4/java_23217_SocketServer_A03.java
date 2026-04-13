import java.io.*;
import java.net.*;

public class java_23217_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server is running and waiting for a client to connect...");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("A new client has connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);

                if (clientMessage.equalsIgnoreCase("exit")) {
                    out.println("Goodbye!");
                    break;
                } else {
                    out.println("Hello, you sent: " + clientMessage);
                }
            }

            socket.close();
        }
    }
}
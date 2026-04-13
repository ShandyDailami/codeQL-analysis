import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_42083_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);

                if ("exit".equals(clientMessage)) {
                    break;
                }

                // Security-sensitive operation: Checking if the message is empty
                if ("".equals(clientMessage)) {
                    out.println("Error: Empty message received");
                } else {
                    out.println("Thank you for message: " + clientMessage);
                }
            }

            socket.close();
        }
    }
}
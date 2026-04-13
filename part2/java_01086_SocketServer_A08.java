import java.io.*;
import java.net.*;

public class java_01086_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            socket = serverSocket.accept();
            System.out.println("Client has connected");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while (true) {
                message = in.readLine();
                if (message == null) break;
                System.out.println("Received: " + message);

                // For the purpose of this example, we'll just echo the message back.
                // In a real application, you would want to use a more secure method to send messages.
                out.println(message);
           
            }
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
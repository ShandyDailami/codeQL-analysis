import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16153_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server started on port 12345");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                OutputStream outputStream = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Received from client: " + clientMessage);

                    if ("exit".equalsIgnoreCase(clientMessage)) {
                        writer.println("Successfully disconnected from client");
                        break;
                    } else {
                        writer.println("Authentication failed. Please try again.");
                    }
                }

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
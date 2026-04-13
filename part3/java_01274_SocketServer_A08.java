import java.io.*;
import java.net.*;

public class java_01274_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server is running and waiting for client...");

            while (true) {
                Socket socket = server.accept();

                // Set up input and output streams
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String clientMessage, serverMessage;

                // Read client's message
                clientMessage = in.readLine();
                System.out.println("Client says: " + clientMessage);

                // Generate server's response
                serverMessage = "Server's response: " + clientMessage;
                out.println(serverMessage);

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            System.out.println("Error in server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
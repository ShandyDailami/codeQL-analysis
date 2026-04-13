import java.io.*;
import java.net.*;

public class java_35523_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Read input from the client
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String input = reader.readLine();
                System.out.println("Received: " + input);

                // Inject code here to manipulate the input
                // For example, we'll append a string to the input
                String injectedInput = "Injected: " + input;
                System.out.println("Injected: " + injectedInput);

                // Write the response back to the client
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println(injectedInput);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
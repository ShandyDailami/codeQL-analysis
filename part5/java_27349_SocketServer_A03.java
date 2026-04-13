import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class java_27349_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            // Create server socket
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                // Accept a new connection
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Get input and output streams
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                OutputStream out = socket.getOutputStream();

                // Read the request
                String request = in.readLine();
                System.out.println("Received: " + request);

                // Respond with a "Hello, client" message
                out.write("Hello, client\n".getBytes());
                out.flush();

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
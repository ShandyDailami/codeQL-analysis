import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class java_39542_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port: " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                InputStream input = clientSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String message = reader.readLine();
                System.out.println("Received: " + message);

                // For the simplicity of this example, we'll just echo back the message
                String response = "Echo: " + message;
                clientSocket.getOutputStream().println(response);
                clientSocket.getOutputStream().flush();

                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
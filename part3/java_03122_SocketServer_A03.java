import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03122_SocketServer_A03 {

    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");
            OutputStream outputStream = clientSocket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = reader.readLine();
            System.out.println("Message received: " + message);
            String response = processInjection(message);
            outputStream.write(response.getBytes());
            outputStream.close();
            clientSocket.close();
        }
    }

    private static String processInjection(String message) {
        // This is a security-sensitive operation related to Injection A03_Injection
        // Here we're just returning the input message back to the client
        return message;
    }
}
import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_16721_SocketServer_A08 {

    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws Exception {
        ServerSocket(serverSocket, 8080);

        while (true) {
            SSLSocket clientSocket = serverSocket.accept();
            handleClient(clientSocket);
        }
    }

    private static void handleClient(SSLSocket clientSocket) throws IOException {
        InputStream input = clientSocket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        System.out.println("Client connected");

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("Received: " + line);
            if (line.equals("exit")) {
                break;
            }
       
            System.out.println("Sending: Hello Client");
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            writer.println("Hello Client");
        }

        clientSocket.close();
        System.out.println("Client disconnected");
    }
}
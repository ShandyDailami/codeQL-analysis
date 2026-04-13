import java.net.*;
import java.io.*;
import java.util.*;

public class java_00057_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String request;
            while ((request = in.readLine()) != null) {
                // Perform security sensitive operations related to A03_Injection
                // For simplicity, we're just echoing back the request
                out.println("Echo: " + request);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
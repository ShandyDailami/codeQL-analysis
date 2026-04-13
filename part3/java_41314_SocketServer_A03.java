import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41314_SocketServer_A03 {

    public static void main(String[] args) {
        int port = 1234;
        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            clientSocket = serverSocket.accept();
            System.out.println("A client has connected: " + clientSocket.getInetAddress().getHostAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Echo: " + message);
            }

            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Ensure resources are properly closed.
            if (serverSocket != null) {
                try { serverSocket.close(); } catch (IOException e) { /* Can't do anything */ }
            }
            if (clientSocket != null) {
                try { clientSocket.close(); } catch (IOException e) { /* Can't do anything */ }
            }
        }
    }
}
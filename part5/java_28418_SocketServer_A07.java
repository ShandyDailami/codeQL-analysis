import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class java_28418_SocketServer_A07 {

    private ServerSocket serverSocket;

    public void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);
            handleClient();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stopServer();
        }
    }

    private void stopServer() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClient() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A client has connected");
                handleRequest(clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleRequest(Socket socket) {
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            Scanner scanner = new Scanner(inputStream);
            String request = scanner.nextLine();

            if (isAuthFailure(request)) {
                outputStream.write("Authentication failed. Please log in again.\n".getBytes());
            } else {
                outputStream.write("Request processed successfully.\n".getBytes());
            }

            outputStream.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isAuthFailure(String request) {
        // Here you would add the logic to check if the request is an auth failure.
        // This would depend on how your server is set up and how you're handling authentication.
        // For example, you might check if the request contains specific error messages.
        return false;
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer();
        server.startServer(5000);
    }
}
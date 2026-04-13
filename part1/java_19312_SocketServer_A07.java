import java.io.*;
import java.net.*;
import java.util.*;

public class java_19312_SocketServer_A07 {
    private static final String HOST = "localhost";
    private static final int PORT = 8000;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                handleClient(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket socket) {
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request, response;
            while ((request = in.readLine()) != null) {
                System.out.println("Received request: " + request);
                if (isValidRequest(request)) {
                    response = "HTTP/1.1 200 OK\r\n\r\n" + "Hello, client!";
                } else {
                    response = "HTTP/1.1 401 Unauthorized\r\n\r\n";
                }
                out.println(response);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isValidRequest(String request) {
        // This is a placeholder for authentication. In a real-world scenario,
        // the authentication process would involve comparing the request with a stored hash.
        // The comparison would use a secure hash algorithm like SHA-256 or a similar one.
        // In this example, we're just checking if the request contains "admin" in it.
        return request.contains("admin");
    }
}
import java.io.*;
import java.net.*;
import java.util.*;

public class java_40630_SocketServer_A03 {

    private static final String CHARSET = "UTF-8";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");
                handleRequest(socket);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleRequest(Socket socket) {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), CHARSET));
            writer = new PrintWriter(socket.getOutputStream(), true);
            String request = reader.readLine();
            System.out.println("Received request: " + request);
            String response = processRequest(request);
            writer.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    private static String processRequest(String request) {
        // TODO: Implement request processing, sanitize and validate the request, and return the response
        // For now, let's just return the input request
        return request;
    }
}
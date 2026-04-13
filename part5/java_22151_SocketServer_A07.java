import java.io.*;
import java.net.*;

public class java_22151_SocketServer_A07 {
    private int port;
    private ServerSocket serverSocket;

    public java_22151_SocketServer_A07(int port) {
        this.port = port;
        startServer();
    }

    private void startServer() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);
            while (true) {
                handleClient(serverSocket.accept());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void handleClient(Socket clientSocket) {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String message, response;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                if (message.equals("exit")) {
                    out.println("Server shutting down");
                    break;
                }

                response = processRequest(message);
                out.println(response);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String processRequest(String request) {
        // Add authentication logic here for A07_AuthFailure
        // For now, let's return a basic response
        return "Server received: " + request;
    }

    public static void main(String[] args) {
        new MyServer(8080);
    }
}
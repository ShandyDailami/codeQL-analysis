import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24188_SocketServer_A01 {
    private static final int HTTP_PORT = 8080;
    private static final int TCP_PORT = 1337;

    public static void main(String[] args) {
        runServer(HTTP_PORT, false);
        runServer(TCP_PORT, true);
    }

    private static void runServer(int port, boolean tcp) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                if (tcp) {
                    handleTcpConnection(clientSocket);
                } else {
                    handleHttpConnection(clientSocket);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleHttpConnection(Socket socket) {
        try (Socket clientSocket = socket;
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String request = in.readLine();
            System.out.println("HTTP Request: " + request);

            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/plain;charset=utf-8");
            out.println("Content-Length: 2");
            out.println();
            out.println("Hi");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleTcpConnection(Socket socket) {
        try (Socket clientSocket = socket;
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String request = in.readLine();
            System.out.println("TCP Request: " + request);

            out.println("TCP Message: OK");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
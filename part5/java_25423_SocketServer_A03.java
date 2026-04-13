import java.io.*;
import java.net.*;
import java.util.Scanner;

public class java_25423_SocketServer_A03 {
    private static final String SERVER_STATE = "HTTP/1.1 200 OK\r\n" +
            "Server: Nginx\r\n" +
            "Date: Tue, 15 Oct 2008 22:00:00 GMT\r\n" +
            "Content-Type: text/html; charset=UTF-8\r\n" +
            "Content-Length: 13\r\n" +
            "\r\n" +
            "Hello, world!";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started.");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client accepted: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request = in.readUTF();
                System.out.println("Request: " + request);

                String response = handleRequest(request);

                out.writeUTF(response);
                out.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String handleRequest(String request) {
        if (request.contains("DROP TABLE")) {
            // Inject SQL query to drop table
            request = request.replace("DROP TABLE", "DROP TABLE `test`;");
        } else if (request.contains("SELECT * FROM")) {
            // Inject SQL query to select data
            request = request.replace("SELECT * FROM", "SELECT * FROM `test`;");
        }
        return SERVER_STATE + "\r\n" + "Server terminated: " + request;
    }
}
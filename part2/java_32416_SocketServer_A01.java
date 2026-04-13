import java.io.*;
import java.net.*;

public class java_32416_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started on port 1234");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String requestLine = in.readLine();
            System.out.println("Request: " + requestLine);

            if (requestLine.startsWith("GET")) {
                String response = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/plain; charset=utf-8\r\n" +
                        "Content-Length: 11\r\n" +
                        "\r\n" +
                        "Hello, World!";
                out.write(response.getBytes());
            } else {
                String response = "HTTP/1.1 405 Method Not Allowed\r\n" +
                        "Content-Type: text/plain; charset=utf-8\r\n" +
                        "Content-Length: 16\r\n" +
                        "\r\n" +
                        "Invalid HTTP method used!";
                out.write(response.getBytes());
            }

            out.flush();
            socket.close();
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13726_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String request, response;
                while ((request = in.readLine()) != null) {
                    if ("GET".equals(request)) {
                        response = "HTTP/1.1 200 OK\r\n" +
                                "Content-Type: text/html; charset=UTF-8\r\n" +
                                "\r\n" +
                                "<h1>Hello, World!</h1>\r\n";
                        out.println(response);
                    } else {
                        response = "HTTP/1.1 405 Method Not Allowed\r\n" +
                                "Content-Type: text/html; charset=UTF-8\r\n" +
                                "\r\n" +
                                "<h1>Method not supported.</h1>\r\n";
                        out.println(response);
                    }
                }
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
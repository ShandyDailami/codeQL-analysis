import java.io.*;
import java.net.*;
import java.util.*;

public class java_24638_SocketServer_A01 {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(80);

        while (true) {
            Socket socket = serverSocket.accept();

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String request = reader.readLine();
            System.out.println("Received request: " + request);

            writer.println("HTTP/1.1 200 OK");
            writer.println("Content-Type: text/html; charset=utf-8");
            writer.println();
            writer.println("<h1>Hello, World!</h1>");

            socket.close();
        }
    }
}
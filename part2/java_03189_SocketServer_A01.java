import java.io.*;
import java.net.*;

public class java_03189_SocketServer_A01 {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running...");

        while (true) {
            Socket socket = serverSocket.accept();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String request, response;
            while ((request = in.readLine()) != null) {
                System.out.println("Received request: " + request);

                if (request.equals("exit")) {
                    response = "Server is shutting down...";
                } else {
                    response = "Hello, client!";
                }

                out.println(response);
            }

            out.close();
            socket.close();
        }
    }
}
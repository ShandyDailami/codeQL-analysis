import java.io.*;
import java.net.*;

public class java_24444_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String request;
            while ((request = in.readLine()) != null) {
                if (request.contains("badword")) {
                    out.println("Bad word detected, please try again.");
                    out.flush();
                    continue;
                }

                // Otherwise, process the request
                out.println("Received: " + request);
                out.flush();
            }

            socket.close();
        }
    }
}
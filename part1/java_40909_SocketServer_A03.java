import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40909_SocketServer_A03 {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(clientSocket.getInputStream()))) {

                    String request, response;
                    while ((request = in.readLine()) != null) {
                        System.out.println("Received client: " + request);

                        // For security purposes, we're just echoing back the request
                        response = request;

                        out.println(response);
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
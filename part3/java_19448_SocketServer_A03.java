import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19448_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server is running...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String request;
            while ((request = in.readLine()) != null) {
                System.out.println("Received: " + request);
                String response;
                if (request.startsWith("query")) {
                    response = "You've been injected!";
                } else {
                    response = "Invalid request.";
                }
                out.println(response);
            }
            socket.close();
        }
    }
}
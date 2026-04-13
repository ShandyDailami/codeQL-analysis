import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08125_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started at " + server.getLocalSocketAddress());

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected at " + socket.getRemoteSocketAddress());

            // Create input and output stream
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Handle each request
            String request;
            while ((request = in.readLine()) != null) {
                System.out.println("Received: " + request);

                // Security-sensitive operations
                String response = processRequest(request);

                out.println(response);
            }

            socket.close();
        }
    }

    private static String processRequest(String request) {
        // For example: echo the request back
        return request;
    }
}
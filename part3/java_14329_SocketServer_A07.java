import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_14329_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        int port = 8080; // default port

        // check if arguments are provided
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        // initialize server socket
        java.net.ServerSocket serverSocket = new java.net.ServerSocket(port);
        System.out.println("Server is listening on port " + port);

        while (true) {
            // wait for client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // read from client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = in.readLine();
            System.out.println("Received: " + message);

            // check if client is authenticated
            if (message.equals("authenticate")) {
                // write response to client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("authenticated");
            } else {
                // if client is not authenticated, close connection
                clientSocket.close();
            }
        }
    }
}
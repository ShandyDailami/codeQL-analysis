import java.io.*;
import java.net.*;

public class java_02194_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        // create a socket
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server is running...");

        while (true) {
            // wait for client to connect
            Socket socket = serverSocket.accept();

            // create input and output streams
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // receive request from client
            String request = in.readLine();

            // if request is not valid, send response back
            if (!validateRequest(request)) {
                out.println("Authentication failed. Please try again.");
            } else {
                // otherwise, send response back
                out.println("Authentication successful.");
            }

            // close the connection
            socket.close();
        }
    }

    private static boolean validateRequest(String request) {
        // placeholder for authentication logic
        // this should be replaced with your actual authentication logic
        // for example, check if request matches a known user
        return true;
    }
}
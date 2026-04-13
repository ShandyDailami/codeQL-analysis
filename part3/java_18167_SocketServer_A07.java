import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_18167_SocketServer_A07 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                Handler handler = new Handler(socket);
                executor.execute(handler);
            } catch (IOException e) {
                System.err.println("Error accepting client connection");
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_18167_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                System.err.println("Error setting up I/O streams");
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                String message, response;
                while ((message = in.readLine()) != null) {
                    response = handleRequest(message);
                    out.println(response);
                }
            } catch (IOException e) {
                System.err.println("Error handling client");
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("Error closing socket");
                    e.printStackTrace();
                }
            }
        }

        private String handleRequest(String request) {
            // This is a very basic authentication mechanism.
            // Real applications would need to use a more secure method.
            // The example below just checks if the request is "auth" and returns a response.
            if (request.equals("auth")) {
                return "success";
            } else {
                return "failure";
            }
        }
    }
}
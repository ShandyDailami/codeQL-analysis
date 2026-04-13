import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_22258_SocketServer_A08 {

    private static ExecutorService exec = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server started...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            Handler handler = new Handler(socket);
            exec.execute(handler);
        }
    }

    static class Handler implements Runnable {
        Socket socket;

        public java_22258_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received client: " + request);

                    // Here's the part where we introduce a security failure
                    // Let's say we are trying to calculate the length of a request
                    int length = request.length();

                    // But to prevent a Denial of Service (DoS) attack, we'll introduce a check here
                    if (length > 10000) {
                        out.println("Error: Request is too long!");
                    } else {
                        out.println("Success: Length of the request is " + length);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading from client.");
            }
        }
    }
}
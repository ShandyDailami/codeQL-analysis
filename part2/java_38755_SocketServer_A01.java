import java.io.*;
import java.net.*;

public class java_38755_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server is listening on port 8189");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

            // Fork off a new thread to handle the request
            new HandlerThread(socket).start();
        }
    }

    static class HandlerThread extends Thread {
        private final Socket socket;

        public java_38755_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);

                    // Simulate a security-sensitive operation
                    if (inputLine.equals("BREAK")) {
                        System.out.println("Access denial!");
                        out.println("Access denial!");
                        break;
                    }

                    out.println("Echo: " + inputLine);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
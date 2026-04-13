import java.io.*;
import java.net.*;

public class java_31399_SocketServer_A03 {

    // Define the port number
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        while (true) {
            Socket socket = server.accept();
            new Handler(socket).start();
        }
    }

    // Inner class for handling individual client
    private static class Handler extends Thread {
        private Socket socket;
        public java_31399_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Get input and output streams
                InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream();

                // Read the client's request
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String request = reader.readLine();

                // Parse the request and handle the response
                if (request != null && request.toLowerCase().equals("close")) {
                    output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    output.flush();
                    socket.close();
                } else {
                    String response = "HTTP/1.1 400 Bad Request\r\n\r\n";
                    output.write(response.getBytes());
                    output.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
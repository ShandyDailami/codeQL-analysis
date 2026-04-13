import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_18248_SocketServer_A07 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {

        executor = Executors.newCachedThreadPool();

        ServerSocket server = new ServerSocket(12345); // port number

        System.out.println("Server started at port 12345");

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected");
                Handler handler = new Handler(socket);
                executor.execute(handler);
            } catch (Exception e) {
                e.printStackTrace();
                server.close();
            }
        }
    }
}

class Handler implements Runnable {

    private Socket socket;

    public java_18248_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                // perform authentication
                if (!authenticate(message)) {
                    throw new AuthenticationFailureException("Authentication failed");
                }
                // if authentication successful, then echo back the message
                sendResponse(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean authenticate(String message) {
        // TODO: Implement authentication logic
        return true;
    }

    private void sendResponse(String message) {
        try {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println("Message received: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_12517_SocketServer_A07 implements Runnable {
    private Socket socket;

    public java_12517_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (Socket socket = this.socket;
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String request, response;
            while ((request = in.readLine()) != null) {
                System.out.println("Received: " + request);

                if (request.equals("exit")) {
                    response = "Goodbye!";
                } else {
                    response = "Hello, " + request;
                }

                out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class SocketServerExample {
    public static void main(String[] args) throws IOException {
        int port = 4444;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started on port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                new Thread(new MySocketHandler(socket)).start();
            }
        }
    }
}
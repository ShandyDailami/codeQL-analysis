import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_24305_SocketServer_A07 {

    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Server started on port: 6000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client connected");

            Handler handler = new Handler(socket);
            executor.execute(handler);
        }
    }

    static class Handler implements Runnable {
        Socket socket;

        public java_24305_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String clientMessage = reader.readLine();
                System.out.println("Received client message: " + clientMessage);

                // AuthFailure here, using basic username and password
                if ("username".equals(clientMessage) && "password".equals(reader.readLine())) {
                    writer.write("A07_AuthSuccess\n".getBytes());
                } else {
                    writer.write("A07_AuthFailure\n".getBytes());
                }

                writer.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
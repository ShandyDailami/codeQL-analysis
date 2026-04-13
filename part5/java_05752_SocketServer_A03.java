import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_05752_SocketServer_A03 {

    private static ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            pool.execute(new SocketHandler(clientSocket));
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;

        public java_05752_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String request = reader.readLine();
                System.out.println("Received request: " + request);

                if (request != null && request.contains("A03_Injection")) {
                    System.out.println("Attempting injection attack!");
                    output.writeBytes("HTTP/1.1 400 Bad Request\r\n\r\n");
                } else {
                    output.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
                }

                output.flush();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
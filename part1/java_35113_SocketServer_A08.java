import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.BasicAuthenticator;

public class java_35113_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        // Authenticate the server
        Authenticator auth = new BasicAuthenticator("secret");
        server.setAuthenticator(auth);

        server.createContext("/", new MyHandler());

        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class MyHandler extends com.sun.net.httpserver.HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            OutputStream os = t.getResponseOutputStream();
            String response = "Hello World";

            t.getRequestHeaders().entrySet().forEach(System.out::println);

            os.write(response.getBytes());
            os.flush();
            os.close();
        }
    }
}
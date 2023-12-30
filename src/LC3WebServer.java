import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class LC3WebServer {

    public static void main(String[] args) throws IOException {
        int port = 8000; // You can choose your desired port
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // Set up contexts for static files and API
        server.createContext("/api", new ApiHandler());
        server.createContext("/", new StaticFileHandler());

        server.setExecutor(null); // Use the default executor
        server.start();
        System.out.println("Server started on port " + port);
    }
}

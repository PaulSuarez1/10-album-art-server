import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTTPRequest {
    public String path;

    public HTTPRequest(BufferedReader inFromClient) {
        processRequest(inFromClient);
    }

    public void processRequest(BufferedReader inFromClient) {
        try {
            // peel off the first GET/POST PATH line
            // "GET /home.html HTTP/1.1"
            // ["GET", "/home.html", "HTTP/1.1"][1]
            String requestLine = inFromClient.readLine();
            this.path = requestLine.split(" ")[1];

            if (this.path.equals("/")) {
                this.path = "/index.html";
            }
        } catch (IOException e) {
            System.out.println("Error parsing HTTP request: " + this.path);
        }
    }

    public static Map queryParams(String key, String value) throws IOException {
        Map<String, String> pair = new HashMap<>();

        Document paul = Jsoup.connect("/search").get();
        System.out.println(paul.html());

        return pair;
    }
}

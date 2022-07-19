package httpRequests;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class DifferentTypesOfHttpRequests {
  // Get request using HttpClient and HttpRequest
  public static void getRequestExample() throws IOException, InterruptedException {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://www.tutorialspoint.com/servlets/index.htm")).build();

    HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

    System.out.println(response.body());
  }

  // Get request using HttpURLConnection
  public static void getRequestExample1() throws IOException {
    HttpURLConnection connection = null;

    String url = "https://www.tutorialspoint.com/servlets/index.htm";

    try {
      URL newURL = new URL(url);
      connection = (HttpURLConnection) newURL.openConnection();
      connection.setRequestMethod("GET");

      StringBuilder webPageContent;

      try (BufferedReader in = new BufferedReader(
              new InputStreamReader(connection.getInputStream()))) {

        String line;
        webPageContent = new StringBuilder();

        while ((line = in.readLine()) != null) {

          webPageContent.append(line);
          webPageContent.append(System.lineSeparator());
        }
      }
      System.out.println(webPageContent.toString());
    }
    finally {
      connection.disconnect();
    }
  }

  // Sending post Http requests using java.net.URLConnection
  public static void postRequestExample() throws Exception {
    URL url = new URL("https://postman-echo.com/post");
    String postData = "foo1=bar1&foo2=bar2";

    URLConnection connection = url.openConnection();
    connection.setDoOutput(true);
    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    connection.setRequestProperty("Content-Length", Integer.toString(postData.length()));

    try (DataOutputStream output = new DataOutputStream(connection.getOutputStream())) {
      output.writeBytes(postData);
    }

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    }
  }

  // Sending post Http requests using java.net.HttpURLConnection
  public static void postRequestExample1() {
    try {
      URL url = new URL("https://postman-echo.com/post");
      String postData = "foo1=bar1&foo2=bar2";

      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("POST");
      connection.setDoOutput(true);
      connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      connection.setRequestProperty("Content-Length", Integer.toString(postData.length()));
      connection.setUseCaches(false);

      try (DataOutputStream dos = new DataOutputStream(connection.getOutputStream())) {
        dos.writeBytes(postData);
      }

      try (BufferedReader br = new BufferedReader(new InputStreamReader(
              connection.getInputStream())))
      {
        String line;
        while ((line = br.readLine()) != null) {
          System.out.println(line);
        }
      }
    }
    catch (Exception exception) {
      exception.printStackTrace();
    }
  }


  public static void main(String[] args) throws Exception {
    // Get URL from servlets webpage and print html structure in the terminal using HttpClient and HttpRequest
    getRequestExample();

    // Get URL from servlets webpage and print html structure in the terminal using HttpURLConnection
    getRequestExample1();

    // Post http request to postman-echo site using java.net.URLConnection
    postRequestExample();

    // Post http request to postman-echo site using java.net.HttpURLConnection
    postRequestExample1();
  }
}

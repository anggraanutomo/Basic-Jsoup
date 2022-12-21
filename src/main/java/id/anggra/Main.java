package id.anggra;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main
{
    public static void main(String[] args)
    {
        URL url;

        try {
            url = new URL("https://www.scrapingbee.com/blog");
            HttpURLConnection connection;

            try
            {
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("accept","application/json");

                try
                {
                    InputStream responseStream = connection.getInputStream();
                    Document document = Jsoup.parse(responseStream, "UTF-8", "https://www.scrapingbee.com/blog");
                    System.out.println(document.title());
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
                e.printStackTrace();
        }
    }
}
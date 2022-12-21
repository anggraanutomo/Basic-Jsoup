package id.anggra;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Document document = Jsoup.connect("https://www.scrapingbee.com/blog")
                    .timeout(5000)
                    .get();
            System.out.println(document.title());

            Element content = document.getElementById("content");
            System.out.println(content.childrenSize());

            Elements blogs = document.getElementsByClass("p-10");
            for (Element blog : blogs)
            {
                System.out.println(blog.text());
            }

            for (Element blog : blogs)
            {
                String title = blog.select("h4").text();
                String link = blog.select("a").attr("href");
//                String headerImage = blog.select("img").first().attr("src");
                String headerImage = blog.selectFirst("img").attr("src");
                String authorImage = blog.select("img[src*=authors]").attr("src");

                System.out.println(title);
                System.out.println(link);
                System.out.println(headerImage);
                System.out.println(authorImage);
            }


        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
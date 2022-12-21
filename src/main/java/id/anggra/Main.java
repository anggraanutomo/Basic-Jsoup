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
        for (int i = 1; i <= 4; ++i)
        {
            try
            {
                String url = (i==1) ? "https://www.scrapingbee.com/blog/" : "https://www.scrapingbee.com/blog/page/" + i;

                Document document = Jsoup.connect(url)
                        .timeout(5000)
                        .get();
                System.out.println(document.title() + "/n");


                Element content = document.getElementById("content");
                System.out.println(content.childrenSize());
                System.out.println();

                Elements blogs = document.getElementsByClass("p-10");
                for (Element blog : blogs)
                {
                    System.out.println(blog.text());
                    System.out.println();
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
                    System.out.println();
                }


            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
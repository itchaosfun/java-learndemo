package project;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlStringTest {
    String htmlString = "5ZWm5ZWmPGI+PGk+5ZWm5ZWmPC9pPjwvYj48cD48aW1nIHNyYz0iaHR0cHM6Ly9zczEuYmRzdGF0aWMuY29tLzcwY0Z2WFNoX1ExWW54R2twb1dLMUhGNmhoeS9pdC91PTIzOTAyNTUxMjQsMjc4OTYwNTI5NSZhbXA7Zm09MjYmYW1wO2dwPTAuanBnIj48L3A+PHA+5rSX5Yi35Yi35rSX5Yi35LmmPC9wPjxwPjxicj48L3A+PHA+PGltZyBzcmM9Imh0dHBzOi8vdGltZ3NhLmJhaWR1LmNvbS90aW1nP2ltYWdlJmFtcDtxdWFsaXR5PTgwJmFtcDtzaXplPWI5OTk5XzEwMDAwJmFtcDtzZWM9MTYwMjU2NzcyNTA2NiZhbXA7ZGk9OTk5ZjQ5YWUwNWNlZmE2ZDEyZDU2M2Q0YjAxZTZiOGEmYW1wO2ltZ3R5cGU9MCZhbXA7c3JjPWh0dHAlM0ElMkYlMkZhLmhpcGhvdG9zLmJhaWR1LmNvbSUyRnpoaWRhbyUyRnBpYyUyRml0ZW0lMkY3NzA5NGIzNmFjYWYyZWRkMDMzZmE5YTU4ZjEwMDFlOTM4MDE5M2I0LmpwZyI+PC9wPg==";

    public void parse() {
        String decode = Base64Util.decode(htmlString);
        Document document = Jsoup.parse(decode);
        Elements elements = document.select("img[src]");
        for (Element element : elements) {
            String src = element.attr("src");
            System.out.println("src = " + src);
        }
    }

}

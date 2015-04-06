import org.json.JSONObject;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CourseFactory {
    public static JSONObject create(Element element) {
        JSONObject course = new JSONObject();
        Elements elements = element.getElementsByTag("td");

        course.put("course", elements.get(0).text());
        course.put("courseName", elements.get(1).text());
        course.put("instructor", elements.get(2).text());

        JSONObject hours = new JSONObject();
        hours.put("lecture", elements.get(3).text());
        hours.put("lab", elements.get(4).text());
        course.put("hours", hours);

        JSONObject credits = new JSONObject();
        credits.put("bilkent", elements.get(5).text());
        credits.put("ects", elements.get(6).text());
        course.put("credits", credits);

        JSONObject quotas = new JSONObject();
        quotas.put("total", elements.get(7).text().split(" ")[0]);
        quotas.put("available", elements.get(12).text().split(" ")[0]);
        course.put("quotas", quotas);

        course.put("schedule", elements.get(14).text());

        return course;
    }
}
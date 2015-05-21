import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SectionNumber {
    public static JSONArray get(String courseCode, String courseNumber, String sectionNumber) {
        JSONArray courses = CourseCode.get(courseCode);
        JSONArray selectedCourses = new JSONArray();
        for (int i = 0; i < courses.length(); i++) {
            try {
                JSONObject course = courses.getJSONObject(i);
                if (course.getJSONObject("course").getString("number").equals(courseNumber)) {
                    if (course.getJSONObject("course").getString("section").equals(sectionNumber)) {
                        selectedCourses.put(course);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return selectedCourses;
    }
}

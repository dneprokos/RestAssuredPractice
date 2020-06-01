package helpers;

import org.json.simple.JSONObject;

public class UserHelpers {
    public static JSONObject createUserJson(String name, String job) {
        JSONObject reqBody = new JSONObject();
        reqBody.put("name", name);
        reqBody.put("job", job);
        return reqBody;
    }
}

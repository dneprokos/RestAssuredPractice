package regres_site_objects;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    private String id;
    private String name;
    private String job;
    private String createdAt;

    public User() {}

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}

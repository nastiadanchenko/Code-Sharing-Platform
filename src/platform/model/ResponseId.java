package platform.model;

import java.util.UUID;

public class ResponseId {
    private String id;

    public ResponseId(UUID id) {
        this.id = id.toString();
    }

    public String  getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id.toString();
    }
}

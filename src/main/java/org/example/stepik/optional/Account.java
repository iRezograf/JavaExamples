package org.example.stepik.optional;

import java.util.Objects;

public class Account {
    private String id;
    private String type;

    public Account(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public Account(String id) {
        this.id = id;
        this.type = null;    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                "type=" + type+ '}';
    }
}

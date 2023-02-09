package org.example.stepik;

import java.text.SimpleDateFormat;
import java.util.Date;

//import static org.example.stepik.CommentUtils.TEXT_FORMATTER;


public class Comment {
    private static final SimpleDateFormat TEXT_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    private final Date created;
    private final String text;

        public Comment(Date created, String text) {
                this.created = created;
                this.text = text;
        }

    public Date getCreated() {
        return created;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "["+ TEXT_FORMAT.format(getCreated())+"] "+getText();
    }
}

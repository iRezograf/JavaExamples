package org.example.stepik.functionalprogramming;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CommentUtils {
    /**
     * An example string that fits the format "15-03-2020 10:20:34".
     * Use it to print the comments.
     */
    public static final SimpleDateFormat TEXT_FORMATTER = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    public static void main(String[] args) throws ParseException {
        List<Comment> comments = new ArrayList<>();

        comments.add(new Comment(
                CommentUtils.TEXT_FORMATTER.parse("14-03-2020 10:20:34"),
                "What a beautiful photo! Where is it?"
        ));
        comments.add(new Comment(
                CommentUtils.TEXT_FORMATTER.parse("16-03-2020 15:35:18"),
                "I do not know, I just found it on the internet!"
        ));
        comments.add(new Comment(
                CommentUtils.TEXT_FORMATTER.parse("20-03-2020 19:10:22"),
                "Is anyone here?"
        ));

        Date threshold = CommentUtils.TEXT_FORMATTER.parse("15-03-2020 00:00:00");
        int maxTextLength = 30; // it is just an example, do not rely on this number!

        CommentUtils.handleComments(comments, threshold, maxTextLength);
        CommentUtils.printComments(comments);

    }

    private CommentUtils() { }

    /**
     * It processes a given list of comments by removing old comments and shortening the text length
     */
    public static void handleComments(List<Comment> comments, Date thresholdDate, int maxTextLength) {
        comments.removeIf(comment->comment.getCreated().before(thresholdDate));
        // поскольку поле Comment.text финализировано, то зменить модно только
//        создав новый экземпляр  коммента с исправленной длиной
        comments.replaceAll(comment -> new Comment(comment.getCreated(),
                comment.getText().substring(0, Math.min(comment.getText().length(), maxTextLength))));
        // write your code here
    }

    /**
     * It prints each comment in the following format:
     * [14-03-2020 10:20:34] What a beautiful photo! Where is it?
     * [16-03-2020 15:35:18] I do not know, I just found it on the internet!
     * [20-03-2020 19:10:22] Is anyone here?
     * Please, use the formatter above to fit the format.
     */
    public static void printComments(List<Comment> comments) {
//        форматирование вынесено в класс самого объекта toString
        comments.forEach(System.out::println);
        // write your code here
    }
}




class Comment {
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



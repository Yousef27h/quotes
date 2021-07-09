package quotes;

public class Quotes {
    String[] tags;
    String author;
    String likes;
    String text;

    public Quotes(String[] tags, String author, String likes, String text) {
        this.tags = tags;
        this.author = author;
        this.likes = likes;
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

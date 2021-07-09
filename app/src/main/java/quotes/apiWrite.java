package quotes;

public class apiWrite {
    String quoteText;

    public apiWrite(String quoteText) {
        this.quoteText = quoteText;
    }

    @Override
    public String toString() {
        return quoteText;
    }
}

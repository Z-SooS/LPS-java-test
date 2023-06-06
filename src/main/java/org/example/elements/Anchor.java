package org.example.elements;

public class Anchor extends HtmlElement {
    private final String href;

    public Anchor(int depth, String href, Object child, boolean isNewLine) {
        super(depth, child, isNewLine);
        this.href = href;
    }

    @Override
    public String toString() {
        if (child != null) {
            String html = (isNewLine ? "\n" : "") + INDENT.repeat(depth) + "<a href=\"" + href + "\">" + child;
            String ending;
            if (child instanceof HtmlElement childElement && childElement.isNewLine) {
                ending = "\n</a>";
            } else {
                ending = "</a>";
            }
            return html + ending;
        }
        return "";
    }

    @Override
    public String getTagName() {
        return "a";
    }
}

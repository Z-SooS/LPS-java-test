package org.example.elements;

public class Heading extends HtmlElement {
    public Heading(int depth, Object child, boolean isNewLine) {
        super(depth, child, isNewLine);
    }

    @Override
    public String getTagName() {
        return "h1";
    }

    @Override
    public String toString() {
        if (child != null) {
            String html = (isNewLine ? "\n" : "") + INDENT.repeat(depth) + "<h1>" +
                    child;
            String ending;
            if (child instanceof HtmlElement childElement && childElement.isNewLine) {
                ending = "\n</h1>";
            } else {
                ending = "</h1>";
            }
            return html + ending;
        }
        return "";
    }
}

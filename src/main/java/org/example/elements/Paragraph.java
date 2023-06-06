package org.example.elements;

public class Paragraph extends HtmlElement {
    public Paragraph(int depth, Object child, boolean isNewLine) {
        super(depth, child, isNewLine);
    }

    @Override
    public String getTagName() {
        return "p";
    }

    @Override
    public String toString() {
        if (child != null) {
            String html = (isNewLine ? "\n" : "") + INDENT.repeat(depth) + "<p>" +
                    child;
            String ending;
            if (child instanceof HtmlElement childElement && childElement.isNewLine) {
                ending = "\n</p>";
            } else {
                ending = "</p>";
            }
            return html + ending;
        }
        return "";
    }
}

package org.example.elements;

public class TableCell extends HtmlElement{
    public TableCell(int depth, Object child) {
        super(depth, child, true);
    }

    @Override
    public String toString() {
        if(child != null) {
            return "\n" + INDENT.repeat(depth) + "<td>" +
                    child + "</td>";
        }
        return "";
    }

    @Override
    public String getTagName() {
        return "td";
    }
}

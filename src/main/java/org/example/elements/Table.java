package org.example.elements;

import java.util.List;

public class Table extends HtmlElement{
    public Table(int depth, List<TableRow> child) {
        super(depth, child, true);
    }

    @Override
    public String toString() {
        if (child != null) {
            StringBuilder sb = new StringBuilder("\n");
            sb.append(INDENT.repeat(depth)).append("<table>");

            if (child instanceof List<?> elements) {
                elements.forEach(e -> sb.append(e.toString()));
            }

            sb.append("\n").append(INDENT.repeat(depth)).append("</table>");

            return sb.toString();
        }
        return "";
    }

    @Override
    public String getTagName() {
        return "table";
    }
}

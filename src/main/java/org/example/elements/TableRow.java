package org.example.elements;

import java.util.List;

public class TableRow extends HtmlElement{
    public TableRow(int depth, List<TableCell> child) {
        super(depth, child, true);
    }

    @Override
    public String toString() {
        if (child != null){
            StringBuilder sb = new StringBuilder("\n");
            sb.append(INDENT.repeat(depth)).append("<tr>");

            if (child instanceof List<?> elements) {
                elements.forEach(e -> sb.append(e.toString()));
            }

            sb.append("\n").append(INDENT.repeat(depth)).append("</tr>");
            return sb.toString();
        }
        return "";
    }

    @Override
    public String getTagName() {
        return "tr";
    }
}

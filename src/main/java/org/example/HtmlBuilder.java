package org.example;

import org.example.elements.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HtmlBuilder {
    public static final int BASEDEPTH = 2;
    private List<HtmlElement> elements = new ArrayList<>();
    private String title;

    public HtmlBuilder(String title) {
        this.title = title;
    }

    public List<HtmlElement> getElements() {
        return elements;
    }

    public void addElement(HtmlElement element) {
        elements.add(element);
    }


    public void removeElement(ElementType type) {
        Type classType = ElementType.getType(type);

        // Check child elements
        for (HtmlElement element : elements) {
            removeSubElements(element, classType);
        }

        //  null child value means it's empty element and probably no reason to keep if there is no edit function
        elements = elements.stream().filter(e -> e.getClass() != classType && e.getChild() != null).collect(Collectors.toList());
    }

    private void removeSubElements(HtmlElement elementToCheck, Type typeToCheck) {
        if(elementToCheck.getChild().getClass() == typeToCheck) {
            elementToCheck.deleteChild();
            return;
        }
        if(elementToCheck.getChild() instanceof List<?> list) {
            for (Object o : list) {
                if(o instanceof HtmlElement asElement) {
                    if(o.getClass() == typeToCheck) {
                        elementToCheck.deleteChild();
                    }
                    removeSubElements(asElement, typeToCheck);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder generatedHtml = new StringBuilder();
        generatedHtml.append("<!DOCTYPE html>\n<html>\n" + HtmlElement.INDENT + "<head>\n").append(HtmlElement.INDENT.repeat(2)).append(String.format("<title>%s</title>\n", title)).append(HtmlElement.INDENT).append("</head>\n").append(HtmlElement.INDENT).append("<body>\n");

        elements.forEach(e -> generatedHtml.append(e.toString()));

        generatedHtml.append("\n" + HtmlElement.INDENT + "</body>\n</html>");
        return generatedHtml.toString();
    }

    public void setUpExample(String name, String email) {
        title = name + " - Teszt feladat";
        Heading heading = new Heading(BASEDEPTH, "Teszt feladat", false);
        addElement(heading);

        Anchor repoLink = new Anchor(0, "https://github.com/Z-SooS/LPS-java-test", "Megoldás", false);
        Paragraph paragraphWithRepoLink = new Paragraph(BASEDEPTH, repoLink, true);
        addElement(paragraphWithRepoLink);

        Paragraph detailsParagraph = new Paragraph(BASEDEPTH, "A feladat elkészítőjének adatai", true);
        addElement(detailsParagraph);

        TableCell cell1 = new TableCell(4, "name");
        TableCell cell2 = new TableCell(4, name);
        TableCell cell3 = new TableCell(4, "email");
        TableCell cell4 = new TableCell(4, email);

        TableRow tableRow1 = new TableRow(3, Arrays.asList(cell1, cell2));
        TableRow tableRow2 = new TableRow(3, Arrays.asList(cell3, cell4));

        Table table = new Table(2, Arrays.asList(tableRow1, tableRow2));
        addElement(table);

        Anchor lpsLink = new Anchor(BASEDEPTH, "http://lpsolutions.hu", "L&P Solutions", true);
        addElement(lpsLink);
    }
}

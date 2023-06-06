package org.example.elements;

import java.lang.reflect.Type;

public enum ElementType {
    A,
    H1,
    P,
    TABLE,
    TR,
    TD;

    public static boolean contains(String test) {

        for (ElementType type : ElementType.values()) {
            if (type.name().equals(test.toUpperCase())) {
                return true;
            }
        }

        return false;
    }

    public static Type getType(ElementType type) {
        return switch (type) {
            case A -> Anchor.class;
            case P -> Paragraph.class;
            case H1 -> Heading.class;
            case TABLE -> Table.class;
            case TD -> TableCell.class;
            case TR -> TableRow.class;
        };
    }
}

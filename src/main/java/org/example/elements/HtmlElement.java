package org.example.elements;

public abstract class HtmlElement {
    public static final String INDENT = "    ";
    protected boolean isNewLine;
    protected int depth;
    protected Object child;

    public Object getChild() {
        return child;
    }

    public void deleteChild(){
        child = "";
    }

    protected HtmlElement(int depth, Object child, boolean isNewLine) {
        this.depth = depth;
        this.child = child;
        this.isNewLine = isNewLine;
    }

    public abstract String getTagName();
}

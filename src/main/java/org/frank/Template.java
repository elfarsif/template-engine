package org.frank;

public class Template {
    private String templateString;
    private String value;
    private String variable;

    public Template(String templateString) {
        this.templateString = templateString;
    }

    public void set(String variable, String value) {
        this.value = value;
        this.variable = variable;
    }

    public String evaluate() {
        return "Hello, "+value;
    }
}

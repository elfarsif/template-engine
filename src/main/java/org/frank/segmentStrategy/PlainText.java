package org.frank.segmentStrategy;

public class PlainText implements Segment {
    private String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object obj) {
        return text.equals(((PlainText) obj).text);
    }
}

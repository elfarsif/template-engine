package org.frank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Template {
    private String templateText;
    Map<String, String> variables;

    public Template(String templateText) {
        this.templateText = templateText;
        this.variables = new HashMap<>();
    }

    public void set(String variable, String value) {
        this.variables.put(variable, value);
    }

    public String evaluate() {
        TemplateParse parser = new TemplateParse();
        List<String> segments = parser.parse(templateText);
        return concatenate(segments);
    }

    private String concatenate(List<String> segments) {
        StringBuilder result = new StringBuilder();
        for (String segment : segments) {
            append(segment, result);
        }
        return result.toString();
    }

    private void append(String segment, StringBuilder result) {
        if (segment.startsWith("${") && segment.endsWith("}")) {
            String var = segment.substring(2, segment.length() - 1);
            if (!variables.containsKey(var)) {
                throw new MissingValueException("No value for " + segment);
            }
            result.append(variables.get(var));
        } else {
            result.append(segment);
        }
    }


}

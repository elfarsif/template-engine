import org.frank.Template;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TemplateTestPerformance {
    Template template;

    @BeforeEach
    void setUp() {
        buildTemplate();
        populateTemplate();
    }

    private void buildTemplate() {
        StringBuffer text = new StringBuffer(50000);
        for (int i = 0, var = 1; i < 1000; i++, var++) {
            text.append(" template ");
            if (i % 1000 / 50 == 0) {
                text.append("${var").append(var).append("}");
            }
        }
        template = new Template(text.toString());
    }

    private void populateTemplate() {
        for (int var = 1; var < 100; var++) {
            template.set("var" + var, "value of var" + var);
        }
    }

    @Test
    public void templateWith100WordsAnd20Variables() throws Exception {
        long expected = 200L;
        long time = System.currentTimeMillis();
        template.evaluate();
        time = System.currentTimeMillis() - time;
        assertThat(time)
                .as("Rendering the template took " + time + "ms while the target was " + expected + "ms")
                .isLessThan(expected);
    }


}

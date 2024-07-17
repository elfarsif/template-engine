import org.frank.Template;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class TemplateTest {
    @Test
    void evaluateTemplateWithOneVariable(){
        Template template = new Template("Hello, ${name}");
        template.set("name", "Reader");
        assertThat(template.evaluate()).isEqualTo("Hello, Reader");
    }
}

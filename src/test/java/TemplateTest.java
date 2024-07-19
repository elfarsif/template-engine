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

    @Test
    void evaluateTemplateWithDifferentVariable(){
        Template template = new Template("Hello, ${name}");
        template.set("name", "Frank");
        assertThat(template.evaluate()).isEqualTo("Hello, Frank");
    }

    @Test
    void evaluateWithDifferentTemplate(){
        Template template = new Template("Hi, ${name}");
        template.set("name", "Frank");
        assertThat(template.evaluate()).isEqualTo("Hi, Frank");
    }

    @Test
    void multipleVariables(){
        Template template = new Template("${one}, ${two}, ${three}");
        template.set("one", "1");
        template.set("two", "2");
        template.set("three", "3");
        assertThat(template.evaluate()).isEqualTo("1, 2, 3");
    }

    @Test
    public void unknownVariablesAreIgnored() throws Exception {
        Template template = new Template("Hello, ${name}");
        template.set("name", "Reader");
        template.set("doesnotexist", "Hi");
        assertThat(template.evaluate()).isEqualTo("Hello, Reader");
    }
}

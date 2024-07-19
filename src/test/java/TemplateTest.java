import org.frank.Template;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class TemplateTest {
    Template template;

    @BeforeEach
    void givenTemplateWithMultipleVaribles(){
        template = new Template("${one}, ${two}, ${three}");
        template.set("one", "1");
        template.set("two", "2");
        template.set("three", "3");
    }

    @Test
    void itShouldReplaceMultipleVariables(){
        assertTemplateEvaluatesTo("1, 2, 3");
    }

    @Test
    public void itShouldIgnoreUnknownVariables() throws Exception {
        template.set("doesnotexist", "Hi");
        assertTemplateEvaluatesTo("1, 2, 3");
    }

    private void assertTemplateEvaluatesTo(String expected){
        assertThat(template.evaluate()).isEqualTo(expected);
    }
}

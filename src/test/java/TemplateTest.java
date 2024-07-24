import org.frank.utils.MissingValueException;
import org.frank.Template;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TemplateTest {
    Template template;

    @BeforeEach
    void givenTemplateWithMultipleVaribles() {
        template = new Template("${one}, ${two}, ${three}");
        template.set("one", "1");
        template.set("two", "2");
        template.set("three", "3");
    }

    @Test
    void itShouldReplaceMultipleVariables() {
        assertTemplateEvaluatesTo("1, 2, 3");
    }

    @Test
    public void itShouldIgnoreUnknownVariables() throws Exception {
        template.set("doesnotexist", "Hi");
        assertTemplateEvaluatesTo("1, 2, 3");
    }

    @Test
    public void itShouldRaiseExceptionOnMissingValue() {
        try {
            new Template("${foo}").evaluate();
            fail("evaluate() should throw an exception if "
                    + "a variable was left without a value!");
        } catch (MissingValueException expected) {
            assertThat(expected.getMessage()).isEqualTo("No value for ${foo}");
        }
    }

    private void assertTemplateEvaluatesTo(String expected) {
        assertThat(template.evaluate()).isEqualTo(expected);
    }

//    @Test
//    public void variablesGetProcessedJustOnce() throws Exception {
//        template.set("one", "${one}");
//        template.set("two", "${three}");
//        template.set("three", "${two}");
//        assertTemplateEvaluatesTo("${one}, ${three}, ${two}");
//    }
}

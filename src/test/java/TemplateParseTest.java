import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class TemplateParseTest {

    @Test
    public void emptyTemplateRendersAsEmptyString() throws Exception {
        List<String> segments = parse("");
        assertSegments(segments, "");
    }

    @Test
    public void templateWithOnlyPlainText() throws Exception {
        List<String> segments = parse("plain text only");
        assertSegments(segments, "plain text only");

    }

    @Test
    public void parsingMultipleVariables() throws Exception {
        List<String> segments = parse("${a}:${b}:${c}");
        assertSegments(segments, "${a}", ":", "${b}", ":", "${c}");
    }

    private List<String> parse(String templateText) {
        return new TemplateParse().parse(templateText);
    }

    private void assertSegments(List<String> actual, String... expected) {
        assertThat(expected.length)
                .as("Number of Segments dont match")
                .isEqualTo(actual.size());
        assertThat(Arrays.asList(expected))
                .isEqualTo(actual);

    }


}

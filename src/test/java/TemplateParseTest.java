import org.frank.segmentStrategy.PlainText;
import org.frank.segmentStrategy.Segment;
import org.frank.TemplateParse;
import org.frank.segmentStrategy.Variable;
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

    @Test
    public void parsingTemplateIntoSegmentObjects() throws Exception {
        TemplateParse p = new TemplateParse();
        List<Segment> segments = p.parseSegments("a ${b} c ${d}");
        assertSegments(segments,
                new PlainText("a "), new Variable("b"),
                new PlainText(" c "), new Variable("d"));
    }

    private List<String> parse(String templateText) {
        return new TemplateParse().parse(templateText);
    }

    private void assertSegments(List<? extends Object> actual, Object... expected) {
        assertThat(expected.length)
                .as("Number of Segments dont match")
                .isEqualTo(actual.size());
        assertThat(Arrays.asList(expected))
                .isEqualTo(actual);

    }


}

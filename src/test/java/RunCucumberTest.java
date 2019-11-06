import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(features = {"src/test/resources"}, plugin = { "com.consol.citrus.cucumber.CitrusReporter" })
@CucumberOptions(features = {"src/test/resources"})
public class RunCucumberTest {
}
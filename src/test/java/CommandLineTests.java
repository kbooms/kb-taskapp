import com.kevinbooms.CommandLine;
import org.junit.Assert;
import org.junit.Test;

public class CommandLineTests {

    @Test
    public void test_printGreeting() {
        CommandLine sutCL = new CommandLine();
        String greeting = "Checking in!";
        Assert.assertEquals(greeting, sutCL.printGreeting());
    }
}

package befaster.solutions.HLO;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HelloSolutionTest {
    private HelloSolution hello;

    @Before
    public void setUp() {

        hello = new HelloSolution();
    }


    @Test
    public void testHelloWorldEmpty() {
        assertThat(hello.hello(""), equalTo("Hello, World!"));
    }

    @Test
    public void testHelloWorld() {
        assertThat(hello.hello("World"), equalTo("Hello, World!"));
    }

    @Test
    public void testHelloJohn() throws Exception {
        assertThat(hello.hello("John"), equalTo("Hello, John!"));
    }

    @Test
    public void testCraftsman() throws Exception {
        assertThat(hello.hello("Craftsman"), equalTo("Hello, Craftsman!"));
    }


}

package befaster.solutions.CHK;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class CheckoutSolutionTest {
  private CheckoutSolution checkout;

  @Before
  public void setUp() {
    checkout = new CheckoutSolution();
  }

  @Test
  public void testCheckoutABC() throws Exception {
    assertThat(checkout.checkout("A B C"), equalTo(100));
  }

  @Test
  public void testCheckoutABCD() throws Exception {
    assertThat(checkout.checkout("A B C D"), equalTo(115));
  }

  @Test
  public void testIllegalSkuShouldReturnMinusOne() throws Exception {
    assertThat(checkout.checkout("A B Z"), equalTo(-1));
  }

  @Test
  public void testIsValidWithValidItems() throws Exception {
    assertThat(checkout.isValid(Arrays.asList("A B C D".split(" "))), equalTo(true));
  }

  @Test
  public void testIsValidWithInvalidItems() throws Exception {
    assertThat(checkout.isValid(Arrays.asList("A B C D Z".split(" "))), equalTo(false));
  }

  @Test
  public void test3A() throws Exception {
    assertThat(checkout.checkout("A A A"), equalTo(130));
  }

  @Test
  public void test2B() throws Exception {
    assertThat(checkout.checkout("B B"), equalTo(45));
  }
}

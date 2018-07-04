package befaster.solutions.CHK;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;

public class CheckoutSolutionTest {
  private CheckoutSolution checkout;

  @Before
  public void setUp() {
    checkout = new CheckoutSolution();
  }

  @Test
  public void testCheckoutABC() throws Exception {
    assertThat(checkout.checkout("A B C"), equalTo(50 + 30 + 20));
  }
}

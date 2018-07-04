package befaster.solutions.CHK;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class CheckoutSolutionTest {
  private CheckoutSolution checkout;

  private Map<String, Integer> priceMap = new HashMap<>();

  @Before
  public void setUp() {
    priceMap.add("A", 50);
    priceMap.add("B", 30);
    priceMap.add("C", 20);
    priceMap.add("D", 15);
    checkout = new CheckoutSolution(priceMap);
  }

  @Test
  public void testCheckoutABC() throws Exception {
    assertThat(checkout.checkout("A B C"), equalTo(50 + 30 + 20));
  }

  @Test
  public void testCheckoutABCD() throws Exception {
    assertThat(checkout.checkout("A B C D"), equalTo(50 + 30 + 20 + 15));
  }
}

package befaster.solutions.CHK;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class CheckoutSolutionTest {
  private CheckoutSolution checkout;

  private Map<String, Integer> priceMap = new HashMap<>();

  @Before
  public void setUp() {
    priceMap.put("A", 50);
    priceMap.put("B", 30);
    priceMap.put("C", 20);
    priceMap.put("D", 15);
    checkout = new CheckoutSolution(priceMap);
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
}

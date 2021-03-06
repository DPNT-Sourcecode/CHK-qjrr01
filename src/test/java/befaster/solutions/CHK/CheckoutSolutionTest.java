package befaster.solutions.CHK;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
    assertThat(checkout.checkout("A B C")).isEqualTo(100);
  }

  @Test
  public void testCheckoutABCD() throws Exception {
    assertThat(checkout.checkout("A B C D")).isEqualTo(115);
  }

  @Test
  public void testIllegalSkuShouldReturnMinusOne() throws Exception {
    assertThat(checkout.checkout("A B Z")).isEqualTo(-1);
  }

  @Test
  public void testIsValidWithValidItems() throws Exception {
    assertThat(checkout.isValid(Arrays.asList("A B C D".split(" ")))).isEqualTo(true);
  }

  @Test
  public void testIsValidWithInvalidItems() throws Exception {
    assertThat(checkout.isValid(Arrays.asList("A B C D Z".split(" ")))).isEqualTo(false);
  }

  @Test
  public void testCountMap() throws Exception {
    Map<String, Long> expectedCountMap = new HashMap<>();
    expectedCountMap.put("A", 4l);
    expectedCountMap.put("B", 1l);
    List<String> skus = Arrays.asList("A A B A A".split(" "));
    assertThat(CheckoutSolution.countMap(skus)).isEqualTo(expectedCountMap);
  }

  @Test
  public void testCalculateDiscount2A() throws Exception {
    List<String> skus = Arrays.asList("A A A B B".split(" "));
    CheckoutSolution cs = new CheckoutSolution();
    Integer discount = cs.calculateDiscount(skus, "A");
    assertThat(discount).isEqualTo(20);
  }

  @Test
  public void testCalculateDiscount2B() throws Exception {
    List<String> skus = Arrays.asList("A A A B B".split(" "));
    CheckoutSolution cs = new CheckoutSolution();
    Integer discount = cs.calculateDiscount(skus, "B");
    assertThat(discount).isEqualTo(15);
  }

  @Test
  public void test3A() throws Exception {
    assertThat(checkout.checkout("A A A")).isEqualTo(130);
  }

  @Test
  public void test2B() throws Exception {
    assertThat(checkout.checkout("B B")).isEqualTo(45);
  }
}

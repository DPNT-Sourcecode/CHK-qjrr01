package befaster.solutions.CHK;

import java.util.Arrays;
import java.util.Map;

public class CheckoutSolution {

  private Map<String, Integer> priceMap;

  public CheckoutSolution(Map<String, Integer> priceMap) {
    this.priceMap = priceMap;
  }

  public Integer checkout(String skus) {
    Optional<Integer> test = Optional.of(1);
    test.getOrElse(1);
    return Arrays.asList(skus.split(" "))
        .stream()
        .map(sku -> priceMap.getOrDefault(sku, 0))
        .reduce((x, y) -> x + y)
        .getOr(-1);
  }
}

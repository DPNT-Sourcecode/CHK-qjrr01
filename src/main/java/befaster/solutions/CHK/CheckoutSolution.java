package befaster.solutions.CHK;

import java.util.Arrays;
import java.util.Map;

public class CheckoutSolution {

  private Map<String, Integer> priceMap;

  public CheckoutSolution(Map<String, Integer> priceMap) {
    this.priceMap = priceMap;
  }

  public Integer checkout(String skus) {
    return Arrays.asList(skus.split(" "))
        .stream()
        .map(sku -> priceMap.getOrDefault(sku, 0))
        .reduce((x, y) -> x + y)
        .orElse(-1);
  }

    public boolean isValid(List<String> skus) {
        return

    }
}

package befaster.solutions.CHK;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CheckoutSolution {

  private Map<String, Integer> priceMap;

  public CheckoutSolution(Map<String, Integer> priceMap) {
    this.priceMap = priceMap;
  }

  public Integer checkout(String skus) {
    List<String> skuList = Arrays.asList(skus.split(" "));
    if (!isValid(skuList)) {
      return -1;
    }
    return skuList
        .stream()
        .map(sku -> priceMap.getOrDefault(sku, 0))
        .reduce((x, y) -> x + y)
        .orElse(-1);
  }

  public boolean isValid(List<String> skus) {
    return priceMap.keySet().containsAll(skus);
  }
}

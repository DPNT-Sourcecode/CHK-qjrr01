package befaster.solutions.CHK;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutSolution {

  private Map<String, Integer> priceMap = new HashMap<>();

  public CheckoutSolution() {
    priceMap.put("A", 50);
    priceMap.put("B", 30);
    priceMap.put("C", 20);
    priceMap.put("D", 15);
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
        .orElse(0);
  }

  public boolean isValid(List<String> skus) {
    return priceMap.keySet().containsAll(skus);
  }
}

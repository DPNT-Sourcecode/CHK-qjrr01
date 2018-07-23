package befaster.solutions.CHK;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CheckoutSolution {

  private Map<String, Integer> priceMap;

  public CheckoutSolution() {
    priceMap = new HashMap<>();
    priceMap.put("A", 50);
    priceMap.put("B", 30);
    priceMap.put("C", 20);
    priceMap.put("D", 15);
  }

  public CheckoutSolution(Map<String, Integer> priceMap) {
    this.priceMap = priceMap;
  }

  public Integer checkout(String skus) {
    List<String> skuList = Arrays.asList(skus.split(" "));
    if (!isValid(skuList)) {
      return -1;
    }
    Stream<Integer> prices = skuList.stream().map(sku -> priceMap.getOrDefault(sku, 0));
    return sum();
  }

  public boolean isValid(List<String> skus) {
    return priceMap.keySet().containsAll(skus);
  }

  private Integer sum(Stream<Integer> prices) {
    return prices.mapToInt(Integer::intValue).sum();
  }
}

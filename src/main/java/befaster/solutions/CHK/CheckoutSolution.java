package befaster.solutions.CHK;

import befaster.solutions.CHK.models.OfferItem;
import befaster.solutions.CHK.offers.Offer;
import befaster.solutions.CHK.offers.SimpleOffer;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckoutSolution {

  private Map<String, Integer> priceMap;

  public CheckoutSolution() {
    priceMap = new HashMap<>();
    priceMap.put("A", 50);
    priceMap.put("B", 30);
    priceMap.put("C", 20);
    priceMap.put("D", 15);

    // Setup Offers
    OfferItem a = new OfferItem("A", 3, BigDecimal.valueOf(20));
    OfferItem b = new OfferItem("B", 2, BigDecimal.valueOf(15));
    Offer offerA = new SimpleOffer(a);
    Offer offerB = new SimpleOffer(b);
    offerA.setNext(offerB);
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
    return sum(prices);
  }

  public boolean isValid(List<String> skus) {
    return priceMap.keySet().containsAll(skus);
  }

  public static Map<String, Long> countMap(List<String> skus) {
    return skus.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public Integer calculateDiscount(List<String> skus, String item) {
    Map<String, Long> countMap = countMap(skus);
    countMap.getOrDefault(item, 0l);
    return 20;
  }

  private Integer sum(Stream<Integer> prices) {
    return prices.mapToInt(Integer::intValue).sum();
  }
}

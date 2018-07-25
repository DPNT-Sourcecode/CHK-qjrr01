package befaster.solutions.CHK.offers;

import befaster.solutions.CHK.CheckoutSolution;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class OfferChainProcessor {

  private Offer previous;
  private Offer root;

  public OfferChainProcessor(Offer root) {
    this.root = root;
  }

  private BigDecimal apply(Map<String, Long> countMap, String item) {
    System.out.println("-------------------------");
    System.out.println("item in stream " + item);
    return root.apply(countMap, item);
  }

  public BigDecimal apply(List<String> skus) {
    Map<String, Long> countMap = CheckoutSolution.countMap(skus);
    Set<String> keySet = countMap.keySet();
    System.out.println("KeySet " + keySet.size());
    Stream<BigDecimal> discounts = keySet.stream().map(item -> apply(countMap, item));
    return discounts.reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public void addOffer(Offer offer) {
    if (!root.hasNext()) {
      root.setNext(offer);
    } else {
      previous.setNext(offer);
    }
    previous = offer;
  }
}

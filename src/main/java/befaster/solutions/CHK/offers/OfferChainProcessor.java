package befaster.solutions.CHK.offers;

import befaster.solutions.CHK.CheckoutSolution;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class OfferChainProcessor {

  private Offer root;

  public OfferChainProcessor(Offer root) {
    this.root = root;
  }

  public BigDecimal apply(List<String> skus) {
    Map<String, Long> countMap = CheckoutSolution.countMap(skus);
    Stream<BigDecimal> discounts =
        countMap.keySet().stream().map(item -> root.apply(countMap, item));
    return discounts.reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}

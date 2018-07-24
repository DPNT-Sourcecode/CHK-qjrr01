package befaster.solutions.CHK.offers;

import befaster.solutions.CHK.models.OfferItem;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

public class SimpleOffer implements Offer {

  private Optional<Offer> next;
  private OfferItem offerItem;

  public SimpleOffer(OfferItem offerItem) {
    this.offerItem = offerItem;
    this.next = Optional.empty();
  }

  public void setNext(Offer offer) {
    this.next = Optional.of(offer);
  }

  public BigDecimal apply(Map<String, Long> countMap, String item) {
    Long itemCount = countMap.get(item);
    Integer requiredCount = offerItem.getRequiredCount();
    if (itemCount >= requiredCount) {
      BigDecimal multiplier = BigDecimal.valueOf(itemCount / requiredCount);
      return offerItem.getDiscount().multiply(multiplier);
    }
    return BigDecimal.ZERO;
  }

  public Optional<Offer> getNext() {
    return next;
  }

  public boolean hasNext() {
    return next.isPresent();
  }
}
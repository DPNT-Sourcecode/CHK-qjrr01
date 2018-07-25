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
    System.out.println("item is +" + item);
    Long itemCount = countMap.get(item);
    Integer requiredCount = offerItem.getRequiredCount();
    BigDecimal discount = BigDecimal.ZERO;
    if (itemCount >= requiredCount) {
      BigDecimal multiplier = BigDecimal.valueOf(itemCount / requiredCount);
      BigDecimal itemDiscount = offerItem.getDiscount().multiply(multiplier);
      discount = discount.add(itemDiscount);
    }
    System.out.println("discount for " + item + " is " + discount);
    if (this.hasNext()) {
      System.out.println("this has next");
      getNext().get().apply(countMap, item);
    }
    return discount;
  }

  public Optional<Offer> getNext() {
    return next;
  }

  public boolean hasNext() {
    return next.isPresent();
  }
}

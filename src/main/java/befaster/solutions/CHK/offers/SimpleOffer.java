package befaster.solutions.CHK.offers;

import java.util.Map;
import java.util.Optional;

public class SimpleOffer<T> implements Offer<T> {

  private Optional<Offer<T>> next;

  public void setNext(Offer<T> offer) {
    this.next = next;
  }

  public void apply(Map<String, Long> countMap, String item) {}

  public boolean hasNext() {
    return next.isPresent();
  }
}

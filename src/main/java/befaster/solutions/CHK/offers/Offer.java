package befaster.solutions.CHK.offers;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

public interface Offer {

  void setNext(Offer offer);

  BigDecimal apply(Map<String, Long> countMap, String item);

  boolean hasNext();

  Optional<Offer> getNext();
}

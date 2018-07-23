package befaster.solutions.CHK.offers;

import java.math.BigDecimal;
import java.util.Map;

public interface Offer {

  void setNext(Offer offer);

  BigDecimal apply(Map<String, Long> countMap, String item);

  boolean hasNext();
}

package befaster.solutions.CHK.offers;

import java.util.Map;

interface Offer<T> {

  void setNext(Offer<T> offer);

  void apply(Map<String, Long> countMap, String item);

  boolean hasNext();
}

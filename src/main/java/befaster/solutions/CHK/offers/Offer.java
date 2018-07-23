package befaster.solutions.CHK.offers;

interface Offer<T> {

  void setNext(Offer<T> offer);

  void apply();

  boolean hasNext();
}

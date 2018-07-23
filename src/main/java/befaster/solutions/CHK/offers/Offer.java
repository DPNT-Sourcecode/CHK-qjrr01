package befaster.solutions.CHK.offers;

interface Offer<T> {

  void setNext(Offer<T> offer);

  T apply();
}

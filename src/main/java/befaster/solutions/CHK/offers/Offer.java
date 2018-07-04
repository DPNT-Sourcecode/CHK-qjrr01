package befaster.solutions.CHK.offers;

interface Offer<T> {

  void setNext();

  T apply();
}

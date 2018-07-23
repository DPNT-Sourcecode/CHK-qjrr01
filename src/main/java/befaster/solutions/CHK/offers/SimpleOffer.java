package befaster.solutions.CHK.offers;

public class SimpleOffer<T> implements Offer<T> {

  private Optional<Offer<T>> next;

  public void setNext(Offer<T> offer) {
    this.next = next;
  }

  public void apply() {}

  public boolean hasNext() {}
}

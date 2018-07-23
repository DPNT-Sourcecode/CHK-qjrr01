package befaster.solutions.CHK.offers;

public class SimpleOffer<T> implements Offer<T> {
  private Offer next;

  public void setNext(Offer offer) {
    this.next = next;
  }
}

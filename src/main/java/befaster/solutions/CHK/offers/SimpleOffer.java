package befaster.solutions.CHK.offers;

public class SimpleOffer<Integer> implements Offer<Integer> {
  private Offer<Integer> next;

  public void setNext(Offer<Integer> offer) {
    this.next = next;
  }

  public Integer apply() {
    return Integer.valueOf(1);
  }
}

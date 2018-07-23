package befaster.solutions.CHK.models;

public class OfferItem {
  private String name;
  private Integer count;
  private Integer discount;

  public OfferItem(String name, Integer count, Integer discount) {
    this.name = name;
    this.count = count;
    this.discount = discount;
  }
}

package befaster.solutions.CHK.models;

public class OfferItem {
  private String name;
  private Integer requiredCount;
  private Integer discount;

  public OfferItem(String name, Integer requiredCount, Integer discount) {
    this.name = name;
    this.requiredCount = requiredCount;
    this.discount = discount;
  }

  public String getName() {
    return name;
  }

  public Integer getRequiredCount() {
    return requiredCount;
  }

  public Integer getDiscount() {
    return discount;
  }
}

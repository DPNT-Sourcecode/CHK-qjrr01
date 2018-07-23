package befaster.solutions.CHK.models;

import java.math.BigDecimal;

public class OfferItem {
  private String name;
  private Integer requiredCount;
  private BigDecimal discount;

  public OfferItem(String name, Integer requiredCount, BigDecimal discount) {
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

  public BigDecimal getDiscount() {
    return discount;
  }
}

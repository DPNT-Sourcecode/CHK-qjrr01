package befaster.solutions.CHK.models;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class OfferItemTest {

  @Before
  public void setUp() {}

  @Test
  public void testConstructor() throws Exception {
    new OfferItem("name", 1, new BigDecimal(2));
  }

  @Test
  public void testGetName() throws Exception {
    OfferItem offerItem = new OfferItem("item", 1, new BigDecimal(3));
    assertThat(offerItem.getName()).isEqualTo("item");
  }

  @Test
  public void testRequiredCount() throws Exception {
    OfferItem offerItem = new OfferItem("item", 1, new BigDecimal(3));
    assertThat(offerItem.getRequiredCount()).isEqualTo(1);
  }

  @Test
  public void testGetDiscount() throws Exception {
    OfferItem offerItem = new OfferItem("item", 1, new BigDecimal(3));
    assertThat(offerItem.getDiscount()).isEqualTo(BigDecimal.valueOf(3l));
  }
}

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
    new OfferItem("name", 1, BigDecimal(2));
  }

  @Test
  public void testGetName() throws Exception {
    assertThat(new OfferItem("item", 1, 3).getName()).isEqualTo("item");
  }

  @Test
  public void testRequiredCount() throws Exception {
    assertThat(new OfferItem("item", 1, 3).getRequiredCount()).isEqualTo(1);
  }

  @Test
  public void testGetDiscount() throws Exception {
    assertThat(new OfferItem("item", 1, 3).getDiscount()).isEqualTo(3);
  }
}

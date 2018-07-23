package befaster.solutions.CHK.models;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class OfferItemTest {

  @Before
  public void setUp() {}

  @Test
  public void testConstructor() throws Exception {
    new OfferItem("name", 1, 2);
  }
}

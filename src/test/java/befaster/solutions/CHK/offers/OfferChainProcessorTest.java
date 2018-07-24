package befaster.solutions.CHK.offers;

import static org.assertj.core.api.Assertions.*;

import befaster.solutions.CHK.models.OfferItem;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class OfferChainProcessorTest {

  @Before
  public void setUp() {}

  @Test
  public void testConstructor() throws Exception {
    new OfferChainProcessor(null);
  }

  @Test
  public void testApply() throws Exception {
    OfferItem offerItem = new OfferItem("A", 3, BigDecimal.valueOf(20));
    Offer offer = new SimpleOffer(offerItem);
    OfferChainProcessor processor = new OfferChainProcessor(offer);
    List<String> skus = Arrays.asList("A A B A".split(" "));
    processor.apply(skus);
  }
}
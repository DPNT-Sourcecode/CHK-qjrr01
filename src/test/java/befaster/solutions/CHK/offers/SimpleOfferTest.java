package befaster.solutions.CHK.offers;

import static org.assertj.core.api.Assertions.*;

import befaster.solutions.CHK.models.OfferItem;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class SimpleOfferTest {

  @Before
  public void setUp() {}

  @Test
  public void testConstructor() throws Exception {
    OfferItem offerItem = new OfferItem("A", 3, BigDecimal.valueOf(20));
    new SimpleOffer(offerItem);
  }

  @Test
  public void testSetNextAndHasNext() throws Exception {
    OfferItem offerItem = new OfferItem("A", 3, BigDecimal.valueOf(20));
    Offer offer = new SimpleOffer(offerItem);
    assertThat(offer.hasNext()).isFalse();
    Offer offer2 = new SimpleOffer(offerItem);
    offer.setNext(offer2);
    assertThat(offer.hasNext()).isTrue();
  }

  @Test
  public void testApply() throws Exception {
    OfferItem offerItem = new OfferItem("A", 3, BigDecimal.valueOf(20));
    Offer offer = new SimpleOffer(offerItem);
    Map<String, Long> countMap = new HashMap<>();
    countMap.put("A", 3l);
    assertThat(offer.apply(countMap, "A")).isEqualTo(BigDecimal.valueOf(20));
  }

  @Test
  public void testApplyWithDoubleTheCount() throws Exception {
    OfferItem offerItem = new OfferItem("A", 3, BigDecimal.valueOf(20));
    Offer offer = new SimpleOffer(offerItem);
    Map<String, Long> countMap = new HashMap<>();
    countMap.put("A", 7l);
    assertThat(offer.apply(countMap, "A")).isEqualTo(BigDecimal.valueOf(40));
  }
}

package befaster.solutions.CHK.offers;

import static org.assertj.core.api.Assertions.*;

import befaster.solutions.CHK.models.OfferItem;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
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
    BigDecimal discount = processor.apply(skus);
    assertThat(discount).isEqualTo(BigDecimal.valueOf(20));
  }

  @Test
  public void testApplyMultipleOffers() throws Exception {
    OfferItem a = new OfferItem("A", 3, BigDecimal.valueOf(20));
    OfferItem b = new OfferItem("B", 2, BigDecimal.valueOf(15));
    OfferItem c = new OfferItem("C", 4, BigDecimal.valueOf(10));
    Offer offerA = new SimpleOffer(a);
    Offer offerB = new SimpleOffer(b);
    Offer offerC = new SimpleOffer(c);
    OfferChainProcessor processor = new OfferChainProcessor(offerA);
    processor.addOffer(offerB);
    processor.addOffer(offerC);
    List<String> skus = Arrays.asList("A A B A C C B C C".split(" "));
    BigDecimal discount = processor.apply(skus);
    assertThat(discount).isEqualTo(BigDecimal.valueOf(20));
  }

  @Test
  public void testAddOffer() throws Exception {
    OfferItem a = new OfferItem("A", 3, BigDecimal.valueOf(20));
    OfferItem b = new OfferItem("B", 2, BigDecimal.valueOf(15));
    OfferItem c = new OfferItem("C", 4, BigDecimal.valueOf(10));
    Offer offerA = new SimpleOffer(a);
    Offer offerB = new SimpleOffer(b);
    Offer offerC = new SimpleOffer(c);
    OfferChainProcessor processor = new OfferChainProcessor(offerA);
    processor.addOffer(offerB);
    processor.addOffer(offerC);
    assertThat(offerA.hasNext()).isTrue();
    assertThat(offerA.getNext().isPresent()).isTrue();
    assertThat(offerA.getNext().get()).isEqualTo(offerB);

    assertThat(offerB.hasNext()).isTrue();
    assertThat(offerB.getNext().isPresent()).isTrue();
    assertThat(offerB.getNext().get()).isEqualTo(offerC);

    assertThat(offerC.hasNext()).isFalse();
    assertThat(offerC.getNext().isPresent()).isFalse();
  }
}

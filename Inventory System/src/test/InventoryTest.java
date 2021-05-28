package test;

import main.Inventory;
import main.Item;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @BeforeAll
    public static void shouldRunBeforeExecutingAllTheTest() {
        System.out.println("<---Running before executing all the tests--->");
        System.out.println();
    }

    @AfterAll
    public static void shouldRunAfterExecutingAllTheTest() {
        System.out.println();
        System.out.println("<---Running after executing all the tests--->");
    }

    @Test
    public void testingQualityOfUnExpiredNormalItemsWhenQualityDecreasesByOne() {
        System.out.println("Testing quality Of un-expired normal item when quality decreases by one.");
        Item[] items = new Item[] {
                new Item("Normal Items", 5, 19)
        };
        Inventory application = new Inventory(items);
        application.updateQuality();
        assertEquals("Normal Items", application.items[0].name);
        assertEquals(4, application.items[0].sellIn);
        assertEquals(18, application.items[0].quality);

    }

    @Test
    public void testingQualityOfExpiredNormalItemsWhenQualityDecreasesByTwo() {
        System.out.println("Testing quality of expired normal item when decreases by two.");
        Item[] items = new Item[] {
                new Item("Normal Items", -4, 2)
        };
        Inventory application = new Inventory(items);
        application.updateQuality();
        assertEquals("Normal Items", application.items[0].name);
        assertEquals(-5, application.items[0].sellIn);
        assertEquals(0, application.items[0].quality);

    }

    @Test
    public void testingQualityOfUnexpiredItemAgedBrieWhenQualityIncreasesByOne() {
        System.out.println("Testing quality of un-expired item 'Aged Brie' when increases by one.");
        Item[] items = new Item[] {
                new Item("Aged Brie", 5, 3)
        };
        Inventory application = new Inventory(items);
        application.updateQuality();
        assertEquals("Aged Brie", application.items[0].name);
        assertEquals(4, application.items[0].sellIn);
        assertEquals(4, application.items[0].quality);

    }

    @Test
    public void testingQualityOfExpiredItemAgedBrieWhenQualityIncreasesByTwo() {
        System.out.println("Testing quality of expired item 'Aged Brie' when increases by two.");
        Item[] items = new Item[] {
                new Item("Aged Brie", -1, 4)
        };
        Inventory application = new Inventory(items);
        application.updateQuality();
        assertEquals("Aged Brie", application.items[0].name);
        assertEquals(-2, application.items[0].sellIn);
        assertEquals(6, application.items[0].quality);

    }

    @Test
    public void testingQualityOfUnExpiredItemAgedBrieWhenQualityEqualMaxQualityThreshold() {
        System.out.println("Testing quality of un-expired item 'Aged Brie' when quality is equal to the maximum quality threshold.");
        Item[] items = new Item[] {
                new Item("Aged Brie", 5, 50)
        };
        Inventory application = new Inventory(items);
        application.updateQuality();
        assertEquals("Aged Brie", application.items[0].name);
        assertEquals(4, application.items[0].sellIn);
        assertEquals(50, application.items[0].quality);
    }

    @Test
    public void testingQualityOfBackstagePassesItemWhenSellINDaysIsOverTenDaysAndQualityIncreasesByOne() {
        System.out.println("Testing quality of item 'Backstage Passes' when SellIn days are over ten days and quality is increased by one.");
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 12, 4)
        };
        Inventory application = new Inventory(items);
        application.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", application.items[0].name);
        assertEquals(11, application.items[0].sellIn);
        assertEquals(5, application.items[0].quality);

    }

    @Test
    public void testingQualityOfBackstagePassesItemWhenSellINDaysIsBetweenSixAndTenDaysAndQualityIncreasesByTwo() {
        System.out.println("Testing quality of item 'Backstage Passes' when SellIn days are between six and ten days inclusive and quality increases by two.");
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 6)
        };
        Inventory application = new Inventory(items);
        application.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", application.items[0].name);
        assertEquals(9, application.items[0].sellIn);
        assertEquals(8, application.items[0].quality);
    }

    @Test
    public void testingQualityOfBackstagePassesItemWhenSellINDaysIsLessThanFiveDaysAndQualityIncreasesByThree() {
        System.out.println("Testing quality of un-expired 'Backstage Passes' item when SellIn days are less than five days and quality increases by three.");
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10)
        };
        Inventory application = new Inventory(items);
        application.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", application.items[0].name);
        assertEquals(3, application.items[0].sellIn);
        assertEquals(13, application.items[0].quality);

    }

    @Test
    public void testingQualityOfExpiredBackstagePassesItemWhenQualityWillBeZero() {
        System.out.println("Testing quality of expired 'Backstage Passes' item when quality will be zero.");
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10)
        };
        Inventory application = new Inventory(items);
        application.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", application.items[0].name);
        assertEquals(0, application.items[0].quality);
    }

    @Test
    public void testingQualityOfUnExpiredConjuredItemsWhenDegradationInQualityIsTwiceAsFastAsNormalItems() {
        System.out.println("Testing quality of un-expired 'Conjured item' when degradation in quality is twice ss fast as normal items.");
        Item[] items = new Item[] {
                new Item("Conjured Items", 6, 4)
        };
        Inventory application = new Inventory(items);
        application.updateQuality();
        assertEquals("Conjured Items", application.items[0].name);
        assertEquals(5, application.items[0].sellIn);
        assertEquals(2, application.items[0].quality);

    }

    @Test
    public void testingQualityOfExpiredConjuredItemsWhenDegradationInQualityIsTwiceAsFastAsNormalItems() {
        System.out.println("Testing quality of expired 'Conjured item' when degradation in quality is twice as fast as normal items.");
        Item[] items = new Item[] {
                new Item("Conjured Items", -1, 4)
        };
        Inventory application = new Inventory(items);
        application.updateQuality();
        assertEquals("Conjured Items", application.items[0].name);
        assertEquals(-2, application.items[0].sellIn);
        assertEquals(0, application.items[0].quality);

    }

    @Test
    public void testingQualityOfLegendaryItemSulfurasToCheckItsQualityIsEightyAndItNeverAlters() {
        System.out.println("Testing quality of Legendary item 'Sulfuras' to check its quality is eighty and it never alters.");
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 5, 80)
        };
        Inventory application = new Inventory(items);
        application.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", application.items[0].name);
        assertEquals(5, application.items[0].sellIn);
        assertEquals(80, application.items[0].quality);
    }
}
package main;

import java.lang.Math;
public class Inventory {

    public Item[] items;
    public int maximumQualityValue;
    public int qualityDegradationOfNormalItem;

    public Inventory(Item[] items) {
        this.items = items;
        maximumQualityValue = 50;
        qualityDegradationOfNormalItem = 1;
    }

    public void updateQuality() {

        for (Item item: items) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert") && !item.name.equals("Conjured Items")) {
                    if (item.sellIn < 0)
                        item.quality = Math.max((item.quality - qualityDegradationOfNormalItem * 2), 0);
                    else
                        item.quality = Math.max((item.quality - qualityDegradationOfNormalItem), 0);
                } else if (item.name.equals("Conjured Items")) {
                    if (item.sellIn < 0)
                        item.quality = Math.max((item.quality - qualityDegradationOfNormalItem * 4), 0);
                    else
                        item.quality = Math.max((item.quality - qualityDegradationOfNormalItem * 2), 0);
                } else {
                    item.quality = Math.min((item.quality + 1), maximumQualityValue);

                    if (item.name.equals("Aged Brie")) {
                        if (item.sellIn < 0)
                            item.quality = Math.min((item.quality + 1), maximumQualityValue);
                    } else {
                        if (item.sellIn < 0) {
                            item.quality = 0;
                        } else if (item.sellIn < 6) {
                            item.quality = Math.min((item.quality + 2), maximumQualityValue);
                        } else if (item.sellIn < 11) {
                            item.quality = Math.min((item.quality + 1), maximumQualityValue);
                        }
                    }
                }
                item.sellIn = item.sellIn - 1;
            }
        }
    }
}
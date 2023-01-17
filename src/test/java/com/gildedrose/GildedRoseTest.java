package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private GildedRose gildedRose;
    private Item[] items;

    @BeforeEach
    public void setUp() {
        items = new Item[] {
            new Item("+5 Dexterity Vest", 2, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Conjured Mana Cake", 3, 6),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)
        };
        gildedRose = new GildedRose(items);
    }

    @Test
    public void testDefaultItemQualityDegradesTwiceAsFastAfterSellByDate() {
        gildedRose.updateQuality();
        assertEquals(19, items[0].quality);
        assertEquals(1, items[0].sellIn);
        gildedRose.updateQuality();
        assertEquals(18, items[0].quality);
        assertEquals(0, items[0].sellIn);
        gildedRose.updateQuality();
        assertEquals(16, items[0].quality);
        assertEquals(-1, items[0].sellIn);
    }

    @Test
    public void testAgedBrieQualityIncrease() {
        gildedRose.updateQuality();
        assertEquals(1, items[1].quality);
        assertEquals(1, items[1].sellIn);
        gildedRose.updateQuality();
        assertEquals(2, items[1].quality);
        assertEquals(0, items[1].sellIn);
        gildedRose.updateQuality();
        assertEquals(4, items[1].quality);
        assertEquals(-1, items[1].sellIn);
    }

    @Test
    public void testLegendaryItemQualityDoesNotChange() {
        gildedRose.updateQuality();
        assertEquals(80, items[2].quality);
        gildedRose.updateQuality();
        assertEquals(80, items[2].quality);
    }

    @Test
    public void testConjuredItemQualityDecreasesTwiceAsFastAsNormal() {
        assertEquals(6, items[3].quality);
        gildedRose.updateQuality();
        assertEquals(4, items[3].quality);
    }

    @Test
    public void testBackstagePassesQuality() {
        gildedRose.updateQuality();
        assertEquals(21, items[4].quality);
        assertEquals(14, items[4].sellIn);
        gildedRose.updateQuality();
        assertEquals(22, items[4].quality);
        assertEquals(13, items[4].sellIn);
        gildedRose.updateQuality();
        assertEquals(23, items[4].quality);
        assertEquals(12, items[4].sellIn);
        gildedRose.updateQuality();
        assertEquals(24, items[4].quality);
        assertEquals(11, items[4].sellIn);
        gildedRose.updateQuality();
        assertEquals(26, items[4].quality);
        assertEquals(10, items[4].sellIn);
        gildedRose.updateQuality();
        assertEquals(28, items[4].quality);
        assertEquals(9, items[4].sellIn);
        gildedRose.updateQuality();
        assertEquals(30, items[4].quality);
        assertEquals(8, items[4].sellIn);
        gildedRose.updateQuality();
        assertEquals(32, items[4].quality);
        assertEquals(7, items[4].sellIn);
        gildedRose.updateQuality();
        assertEquals(34, items[4].quality);
        assertEquals(6, items[4].sellIn);
        gildedRose.updateQuality();
        assertEquals(37, items[4].quality);
        assertEquals(5, items[4].sellIn);
        gildedRose.updateQuality();
        assertEquals(40, items[4].quality);
        assertEquals(4, items[4].sellIn);
        gildedRose.updateQuality();
        assertEquals(43, items[4].quality);
        assertEquals(3, items[4].sellIn);
        gildedRose.updateQuality();
        assertEquals(46, items[4].quality);
        assertEquals(2, items[4].sellIn);
        gildedRose.updateQuality();
        assertEquals(49, items[4].quality);
        assertEquals(1, items[4].sellIn);
        gildedRose.updateQuality();
        assertEquals(50, items[4].quality);
        assertEquals(0, items[4].sellIn);
        gildedRose.updateQuality();
        assertEquals(0, items[4].quality);
        assertEquals(-1, items[4].sellIn);
    }


}

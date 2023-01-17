package com.gildedrose.categories;

import com.gildedrose.Item;

public class BackstagePassUpdater implements ItemUpdater{
    @Override
    public void update(Item item) {
        item.sellIn--;
        if (item.quality < 50) {
            item.quality++;
            if (item.sellIn <= 10) {
                if (item.quality < 50) {
                    item.quality++;
                }
            }
            if (item.sellIn <= 5) {
                if (item.quality < 50) {
                    item.quality++;
                }
            }
        }
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}

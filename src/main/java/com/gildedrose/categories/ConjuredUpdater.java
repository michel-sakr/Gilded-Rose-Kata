package com.gildedrose.categories;

import com.gildedrose.Item;

public class ConjuredUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        item.sellIn--;
        if (item.quality > 0) {
            item.quality -= 2;
        }
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality -= 4;
        }
    }
}

package com.gildedrose;

import com.gildedrose.categories.*;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;
    Map<String, ItemUpdater> updaters;


    public GildedRose(Item[] items) {
        this.items = items;
        this.updaters = new HashMap<>();
        updaters.put("Aged Brie", new AgedBrieUpdater());
        updaters.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdater());
        updaters.put("Sulfuras, Hand of Ragnaros", new LegendaryUpdater());
        updaters.put("Conjured Mana Cake", new ConjuredUpdater());
        updaters.put("default", new DefaultUpdater());
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater updater = updaters.getOrDefault(item.name, updaters.get("default"));
            updater.update(item);
        }
    }

    public void update(){

    }
}

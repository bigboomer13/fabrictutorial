package net.boomer.tutorialmod.item;

import net.boomer.tutorialmod.TutorialMod;
import net.boomer.tutorialmod.item.custom.ChiselItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import javax.xml.namespace.QName;

public class ModItems {
    public static final Item JAIL_BIRD = registerItem("jail_bird", new Item(new Item.Settings()));
    public static final Item BROKEN_JAIL_BIRD = registerItem("broken_jail_bird", new Item(new Item.Settings()));
    public static final Item SAUL = registerItem("saul", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));


private static Item registerItem(String name, Item item) {
    return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
}

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items For " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(JAIL_BIRD);
            entries.add(BROKEN_JAIL_BIRD);
            entries.add(SAUL);
            entries.add(CHISEL);
        });
    }
}

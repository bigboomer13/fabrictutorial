package net.boomer.tutorialmod.item;

import net.boomer.tutorialmod.TutorialMod;
import net.boomer.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup JAIL_BIRD_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "jail_bird_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.JAIL_BIRD))
                    .displayName(Text.translatable("itemgroup.tutorial-mod.jail_bird_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.JAIL_BIRD);
                        entries.add(ModItems.BROKEN_JAIL_BIRD);
                        entries.add(ModItems.SAUL);
                        entries.add(ModItems.CHISEL);
                        entries.add(ModItems.SAUL_SNACK);

                    }).build());

    public static final ItemGroup JAIL_BIRD_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "jail_bird_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.JAIL_BIRD_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorial-mod.jail_bird_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.JAIL_BIRD_BLOCK);
                        entries.add(ModBlocks.BROKEN_JAIL_BIRD_BLOCK);
                        entries.add(ModBlocks.SAUL_BLOCK);

                        entries.add(ModBlocks.JAIL_BIRD_ORE);
                        entries.add(ModBlocks.JAIL_BIRD_DEEPSLATE_ORE);

                        entries.add(ModBlocks.MAGIC_BLOCK);

                    }).build());



    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}

package net.boomer.tutorialmod.block;

import net.boomer.tutorialmod.TutorialMod;
import net.boomer.tutorialmod.block.custom.MagicBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block JAIL_BIRD_BLOCK = registerBlock( "jail_bird_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.ANVIL)));

    public static final Block BROKEN_JAIL_BIRD_BLOCK = registerBlock("broken_jail_bird_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.CHAIN)));

    public static final Block SAUL_BLOCK = registerBlock("saul_block",
            new Block(AbstractBlock.Settings.create().strength(0f).sounds(BlockSoundGroup.SCULK_VEIN)));

    public static final Block JAIL_BIRD_ORE = registerBlock("jail_bird_ore",
    new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
            AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block JAIL_BIRD_DEEPSLATE_ORE = registerBlock("jail_bird_deepslate_ore",
    new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
            AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(BlockSoundGroup.GLASS)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings())
        );;
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.JAIL_BIRD_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.BROKEN_JAIL_BIRD_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.SAUL_BLOCK);
        });
    }
}

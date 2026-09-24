package net.kater.katerchaos.item;

import java.util.function.Supplier;

import net.kater.katerchaos.KaterChaos;
import net.kater.katerchaos.block.ModBlocks;

import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,KaterChaos.MOD_ID);

    public static final Supplier<CreativeModeTab> COIN_ITEMS_TAB = CREATIVE_MODE_TAB.register("coin_items_tab", 
    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COPPER_COIN.get()))
        .title(Component.translatable("creativetab.katerchaos.coin_items"))
        .displayItems((ItemDisplayParameters, output) -> {
            output.accept(ModItems.COPPER_COIN);
            output.accept(ModItems.IRON_COIN);
            output.accept(ModItems.GOLD_COIN);
            }).build());

    
    public static final Supplier<CreativeModeTab> COIN_BLOCKS_TAB = CREATIVE_MODE_TAB.register("coin_blocks_tab", 
    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.COOKIE_BLOCK.get()))
        .withTabsBefore( ResourceLocation.fromNamespaceAndPath(KaterChaos.MOD_ID, "coin_items_tab"))
        .title(Component.translatable("creativetab.katerchaos.coin_blocks"))
        .displayItems((ItemDisplayParameters, output) -> { 
            output.accept(ModBlocks.COOKIE_BLOCK);
        }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}

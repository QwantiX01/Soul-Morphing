package org.loaders.soul_morphing.items;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.loaders.soul_morphing.util.Souls;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.init.SoulItems.ITEMS;

public class RegenerationAmulet extends Item {
    private static long lastTick = 0;

    public RegenerationAmulet(Properties properties) {
        super(properties.setId(ResourceKey.create(ITEMS.getRegistryKey(), ResourceLocation.fromNamespaceAndPath(MODID, "caged_soul"))));
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof Player player) {
            long tick = level.getGameTime();
            int regenerationSpeedTicks = Souls.getTotalSoulsRegeneration(player);
            if (tick % (60 - (regenerationSpeedTicks * 10L)) == 0 && tick != lastTick) {
                Souls.addSouls(player, 1);
                lastTick = tick;
            }
        }
    }
}

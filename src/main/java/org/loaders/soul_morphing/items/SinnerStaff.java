package org.loaders.soul_morphing.items;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import static org.loaders.soul_morphing.Soul_morphing.MODID;
import static org.loaders.soul_morphing.init.SoulItems.ITEMS;

public class SinnerStaff extends Item {
    private static int mode = 0;
    //Mode 0: Small/Fast/Cheap
    //Mode 1: Big/Slow/Expensive

    public SinnerStaff(Properties properties) {
        super(properties.setId(ResourceKey.create(ITEMS.getRegistryKey(), ResourceLocation.fromNamespaceAndPath(MODID, "sinners_staff"))));
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (level.isClientSide) {
            if (player.isShiftKeyDown()) {
                player.displayClientMessage(Component.literal("Mode: " + mode), true);
                changeMode();
            }

            switch (mode) {
                case 0 -> {
                    return InteractionResult.SUCCESS;
                }
                case 1 -> {
                    return InteractionResult.PASS;
                }
            }
        }
        return super.use(level, player, hand);
    }

    private void changeMode() {
        if (mode == 0) {
            mode = 1;
        } else {
            mode = 0;
        }
    }
}

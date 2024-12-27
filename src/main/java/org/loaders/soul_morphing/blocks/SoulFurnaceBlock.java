package org.loaders.soul_morphing.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

public class SoulFurnaceBlock extends Block {
    public SoulFurnaceBlock() {
        super(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse(String.format("%s:%s", MODID, "soul_furnace"))))
                .destroyTime(1.0f)
                .explosionResistance(10.0f)
                .sound(SoundType.AMETHYST)
                .lightLevel(state -> 7));
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        super.stepOn(level, pos, state, entity);
    }
}

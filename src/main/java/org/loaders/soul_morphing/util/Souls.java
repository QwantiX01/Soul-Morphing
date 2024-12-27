package org.loaders.soul_morphing.util;

import net.minecraft.world.entity.LivingEntity;
import org.loaders.soul_morphing.attributes.SoulAttributes;

public class Souls {
    public static int getSouls(LivingEntity entity) {
        if (entity != null)
            if (entity.getAttributes().hasAttribute(SoulAttributes.SOULS_COUNT))
                return (int) entity.getAttribute(SoulAttributes.SOULS_COUNT).getBaseValue();
            else return 0;
        else return 0;
    }

    public static int getMaxSouls(LivingEntity entity) {
        if (entity != null)
            if (entity.getAttributes().hasAttribute(SoulAttributes.MAX_SOULS_COUNT))
                return (int) entity.getAttribute(SoulAttributes.MAX_SOULS_COUNT).getBaseValue();
            else return 0;
        else return 0;
    }

    public static void setSouls(LivingEntity entity, int souls) {
        if (entity != null)
            if (entity.getAttributes().hasAttribute(SoulAttributes.SOULS_COUNT))
                entity.getAttribute(SoulAttributes.SOULS_COUNT).setBaseValue(souls);
    }

    public static void addSouls(LivingEntity entity, int souls) {
        if (entity != null)
            if (entity.getAttributes().hasAttribute(SoulAttributes.SOULS_COUNT))
                if (entity.getAttribute(SoulAttributes.SOULS_COUNT).getBaseValue() + souls > getMaxSouls(entity)) {
                    entity.getAttribute(SoulAttributes.SOULS_COUNT).setBaseValue(getSouls(entity) + souls);
                }
    }

    public static boolean trySubtractSouls(LivingEntity entity, int souls) {
        if (entity != null)
            if (entity.getAttributes().hasAttribute(SoulAttributes.SOULS_COUNT))
                if (getSouls(entity) - souls >= 0) {
                    entity.getAttribute(SoulAttributes.SOULS_COUNT).setBaseValue(getSouls(entity) - souls);
                    return true;
                }
        return false;
    }


}

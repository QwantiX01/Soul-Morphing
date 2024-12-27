package org.loaders.soul_morphing.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import org.loaders.soul_morphing.attributes.SoulAttributes;
import org.loaders.soul_morphing.util.Souls;

import static org.loaders.soul_morphing.Soul_morphing.MODID;

@EventBusSubscriber(Dist.CLIENT)
public class CustomScreen {

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void eventHandler(RenderGuiEvent.Pre event) {
        int height = event.getGuiGraphics().guiHeight();
        int width = event.getGuiGraphics().guiWidth();

        Player player = Minecraft.getInstance().player;
        if (player == null) {
            return;
        }
        boolean hasSouls = player.getAttributes().hasAttribute(SoulAttributes.SOULS_COUNT);
        if (!hasSouls)
            return;

        int frame = (int) Math.ceil((double) ((Souls.getSouls(player) * 100) / Souls.getMaxSouls(player)) / 10);

        ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID, String.format("gui/soul_bar/soul_bar_%s.png", frame));
        event.getGuiGraphics().blit(resourceLocation -> RenderType.guiTextured(TEXTURE), TEXTURE, 10, height - 96, 0, 0, 12, 86, 12, 86);
    }

}
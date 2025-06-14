package dev.beecube31.botaniajei.mixins;

import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.client.integration.jei.manapool.ManaPoolRecipeWrapper;

@SideOnly(Side.CLIENT)
@Mixin(value = ManaPoolRecipeWrapper.class, remap = false)
public abstract class MixinManaPoolRecipeWrapper implements IRecipeWrapper {

    @Shadow @Final private int mana;

    /**
     * @author Beecube31
     * @reason Add required mana amount to craft in JEI.
     */
    @Inject(method = "drawInfo", at = @At("RETURN"), remap = false)
    public void botaniajei$addReqManaText(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY, CallbackInfo ci) {
        minecraft.fontRenderer.drawString(String.valueOf(this.mana), 20, 41, 0, false);
    }
}

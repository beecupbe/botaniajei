package dev.beecube31.botaniajei.mixins.botaniatweaks;

import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import quaternary.botaniatweaks.modules.jei.RecipeWrapperAgglomeration;

@SideOnly(Side.CLIENT)
@Mixin(value = RecipeWrapperAgglomeration.class, remap = false)
public abstract class MixinRecipeWrapperAgglomeration implements IRecipeWrapper {
    @Shadow
    int manaCost;

    /**
     * @author Beecube31
     * @reason Add required mana amount to craft in JEI.
     */
    @Inject(method = "drawInfo", at = @At("RETURN"), remap = false)
    public void botaniajei$addReqManaText(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY, CallbackInfo ci) {
        minecraft.fontRenderer.drawString(String.valueOf(this.manaCost), 35, 50, 0, false);
    }
}

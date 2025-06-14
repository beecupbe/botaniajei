package dev.beecube31.botaniajei.mixins;

import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.api.recipe.RecipePureDaisy;
import vazkii.botania.client.integration.jei.puredaisy.PureDaisyRecipeWrapper;

import javax.annotation.Nonnull;

@SideOnly(Side.CLIENT)
@Mixin(value = PureDaisyRecipeWrapper.class, remap = false)
public abstract class MixinPureDaisyRecipeWrapper implements IRecipeWrapper {
    @Unique private RecipePureDaisy botaniajei$recipe;

    @Inject(method = "<init>", at = @At("RETURN"), remap = false)
    private void botaniajei$catchRecipe(RecipePureDaisy recipe, CallbackInfo ci) {
        this.botaniajei$recipe = recipe;
    }

    public void drawInfo(@Nonnull Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        minecraft.fontRenderer.drawString(this.botaniajei$recipe.getTime() * 8 / 20  + "s.", 2, 37, 0, false);
    }
}

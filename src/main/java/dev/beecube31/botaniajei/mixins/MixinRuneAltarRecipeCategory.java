package dev.beecube31.botaniajei.mixins;

import com.mojang.blaze3d.matrix.MatrixStack;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.api.recipe.IRuneAltarRecipe;
import vazkii.botania.client.integration.jei.RunicAltarRecipeCategory;

@Mixin(value = RunicAltarRecipeCategory.class, remap = false)
public abstract class MixinRuneAltarRecipeCategory implements IRecipeCategory<IRuneAltarRecipe> {

    @Inject(
            method = "draw(Lvazkii/botania/api/recipe/IRuneAltarRecipe;Lcom/mojang/blaze3d/matrix/MatrixStack;DD)V",
            at = @At("RETURN"),
            remap = false
    )
    private void botaniajei$renderManaText(IRuneAltarRecipe recipe, MatrixStack ms, double mouseX, double mouseY, CallbackInfo ci) {
        Minecraft.getInstance().font.draw(ms, String.valueOf(recipe.getManaUsage()), 6, 89, 0);
    }
}

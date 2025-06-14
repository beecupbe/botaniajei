package dev.beecube31.botaniajei.mixins;

import com.mojang.blaze3d.matrix.MatrixStack;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.api.recipe.IManaInfusionRecipe;
import vazkii.botania.client.integration.jei.ManaPoolRecipeCategory;

@Mixin(value = ManaPoolRecipeCategory.class, remap = false)
public abstract class MixinManaPoolRecipeCategory implements IRecipeCategory<IManaInfusionRecipe> {

    @Inject(
            method = "draw(Lvazkii/botania/api/recipe/IManaInfusionRecipe;Lcom/mojang/blaze3d/matrix/MatrixStack;DD)V",
            at = @At("RETURN"),
            remap = false
    )
    private void botaniajei$renderManaText(IManaInfusionRecipe recipe, MatrixStack ms, double mouseX, double mouseY, CallbackInfo ci) {
        Minecraft.getInstance().font.draw(ms, String.valueOf(recipe.getManaToConsume()), 20, 41, 0);
    }
}

package dev.beecube31.botaniajei.mixins;

import com.mojang.blaze3d.matrix.MatrixStack;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.api.recipe.IPureDaisyRecipe;
import vazkii.botania.client.integration.jei.PureDaisyRecipeCategory;

@Mixin(value = PureDaisyRecipeCategory.class, remap = false)
public abstract class MixinPureDaisyRecipeCategory implements IRecipeCategory<IPureDaisyRecipe> {

    @Inject(
            method = "draw(Lvazkii/botania/api/recipe/IPureDaisyRecipe;Lcom/mojang/blaze3d/matrix/MatrixStack;DD)V",
            at = @At("RETURN"),
            remap = false
    )
    private void botaniajei$renderManaText(IPureDaisyRecipe recipe, MatrixStack ms, double mouseX, double mouseY, CallbackInfo ci) {
        Minecraft.getInstance().font.draw(ms, recipe.getTime() * 8 / 20  + "s.", 2, 37, 0);
    }
}

package dev.beecube31.botaniajei.mixins;

import com.mojang.blaze3d.matrix.MatrixStack;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vazkii.botania.api.recipe.ITerraPlateRecipe;
import vazkii.botania.client.integration.jei.TerraPlateRecipeCategory;

@Mixin(value = TerraPlateRecipeCategory.class, remap = false)
public abstract class MixinTerraPlateRecipeCategory implements IRecipeCategory<ITerraPlateRecipe> {

    @Inject(
            method = "draw(Lvazkii/botania/api/recipe/ITerraPlateRecipe;Lcom/mojang/blaze3d/matrix/MatrixStack;DD)V",
            at = @At("RETURN"),
            remap = false
    )
    private void botaniajei$renderManaText(ITerraPlateRecipe recipe, MatrixStack ms, double mouseX, double mouseY, CallbackInfo ci) {
        Minecraft.getInstance().font.draw(ms, String.valueOf(recipe.getMana()), 6, 117, 0);
    }

    @ModifyConstant(method = "draw(Lvazkii/botania/api/recipe/ITerraPlateRecipe;Lcom/mojang/blaze3d/matrix/MatrixStack;DD)V", constant = @Constant(intValue = 92), require = 1)
    private int botaniajei$modifyYCoordOfModel(int originalValue) {
        return 85;
    }

    @ModifyConstant(method = "setRecipe(Lmezz/jei/api/gui/IRecipeLayout;Lvazkii/botania/api/recipe/ITerraPlateRecipe;Lmezz/jei/api/ingredients/IIngredients;)V", constant = @Constant(intValue = 92), require = 1)
    private int botaniajei$modifyYCoordOfItemStack(int originalValue) {
        return 85;
    }
}

package net.boomer.tutorialmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent SAUL_SNACK = new FoodComponent.Builder().nutrition(4).saturationModifier(0.15f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 60), 0.45f).build();


}

package net.jleto.mosquitos.item.custom;

import net.jleto.mosquitos.effect.ModEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;


public class EbolaVaccine extends Item {

    public EbolaVaccine(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK; // Make the player drink the vaccine when right-clicked
    }

    @Override

    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {

        // Check if the user is affected by the ebola effect

        if (pLivingEntity instanceof Player) {
            Player player = (Player) pLivingEntity;

            if (player.hasEffect(ModEffects.EBOLA.get())) {
                // Remove the bleed effect
                player.removeEffect(ModEffects.EBOLA.get());
                player.displayClientMessage(Component.literal("You have been cured of Ebola!"), true);
            } else {
                player.displayClientMessage(Component.literal("You don't have Ebola!"), true);
            }

        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);

    }
}




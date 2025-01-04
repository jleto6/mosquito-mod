package net.jleto.mosquitos.item.custom;

import net.jleto.mosquitos.effect.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;


public class BloodBucket extends Item implements DispensibleContainerItem {


    public BloodBucket(RegistryObject<FlowingFluid> pContent, Properties pProperties) {
        super(pProperties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK; // Make the player drink the vaccine when right-clicked
    }

    @Override

    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {

        // Check if the user is affected by the bleed effect
        Player player = null;
        if (pLivingEntity instanceof Player) {
            player = (Player) pLivingEntity;

            if (player.hasEffect(ModEffects.BLEED.get())) {
                // Remove the bleed effect
                player.removeEffect(ModEffects.BLEED.get());
                player.displayClientMessage(Component.literal("You have stopped bleeding!"), true);
            } else {
                player.displayClientMessage(Component.literal("You aren't bleeding!"), true);
            }

            // Store custom bucket properties
            int customStackSize = pStack.getCount();
            CompoundTag customNbt = pStack.getTag();

            // Give the player back the bucket
            ItemStack regularBucket = new ItemStack(Items.BUCKET, customStackSize);
            if (customNbt != null) {
                regularBucket.setTag(customNbt);
            }

            if (!player.getInventory().add(regularBucket)) {
                // If the player's inventory is full, drop the bucket at the player's feet
                player.drop(regularBucket, false);
            }
        }


        return super.finishUsingItem(pStack, pLevel, pLivingEntity);

    }


    @Override
    public boolean emptyContents(@Nullable Player player, Level level, BlockPos blockPos, @Nullable BlockHitResult blockHitResult) {
        return false;
    }
}





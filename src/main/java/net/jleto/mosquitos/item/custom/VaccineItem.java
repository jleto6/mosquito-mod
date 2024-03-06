package net.jleto.mosquitos.item.custom;

import net.jleto.mosquitos.effect.ModEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class VaccineItem extends Item {

    public VaccineItem(Properties properties) {
        super(properties);
       // this.useSound = useSound;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK; // Make the player drink the vaccine when right-clicked
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level world = context.getLevel();
        ItemStack itemStack = context.getItemInHand();

        if (player != null && player.isCrouching()) {
            // If player is crouching, display message and return
            player.displayClientMessage(Component.literal("You can't use the vaccine while sneaking!"), true);
            return InteractionResult.FAIL;
        }

        if (!world.isClientSide() && player != null) { // Check if server-side and player is not null
            // Cure Ebola if the player has the effect
            if (player.hasEffect(ModEffects.EBOLA.get())) {
                player.removeEffect(ModEffects.EBOLA.get());
                player.displayClientMessage(Component.literal("You have been cured of Ebola!"), true);
            } else {
                player.displayClientMessage(Component.literal("You don't have Ebola!"), true);
            }

                // Play sound effect
              //  world.playSound(null, player.getX(), player.getY(), player.getZ(), useSound,
                      //  player.getSoundSource(), 1.0F, 1.0F);

                // Consume the item
                if (!player.isCreative()) {
                    itemStack.shrink(1); // Decrease the stack size by 1
                }
            }

        return InteractionResult.SUCCESS;
    }
}

package ru.winside.testmod.utils;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import ru.winside.testmod.Main;

public class TestModEventHooks {

	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event) {
		EntityLivingBase entity = event.entityLiving;
		World world = event.entityLiving.worldObj;
		final Random rand = new Random();

		if (event.entityLiving.isPotionActive(Main.JustPotion)) {
			if (entity instanceof EntityPlayer && !entity.isInWater() && !entity.onGround) {
				if (entity instanceof EntityPlayer && !entity.isInWater() && !entity.onGround) {
					if (rand.nextInt(128) == 0 && entity.motionY > 0.0) {
						((EntityPlayer) entity).addExhaustion(0.5F);
					}

					if (entity.motionY <= 0.0) {
						if (entity.isSneaking()) {
							entity.motionY = -0.0212;
						} else {
							entity.motionY -= 0.0215D;
						}
					} else if (entity.motionY <= 0.4115) {
						entity.motionY *= 1.298647D;
					}

					if (!entity.isSneaking()) {
						if (Math.abs(entity.motionX) <= 0.4115)
							entity.motionX *= 1.075D;
						if (Math.abs(entity.motionZ) <= 0.4115)
							entity.motionZ *= 1.075D;
					}

					entity.fallDistance = 0.0F;

				}
				if (event.entityLiving.getActivePotionEffect(Main.JustPotion).getDuration() == 0) {
					event.entityLiving.removePotionEffect(Main.JustPotion.id);
					return;
				}
			}
		}
	}
	
	@SubscribeEvent
	public void potionFallEvent(LivingFallEvent event)
	{
		if (event.entityLiving.isPotionActive(Main.JustPotion.id))
		{
			if (event.isCancelable()) event.setCanceled(true);
		}
	}
}

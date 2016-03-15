package ru.winside.testmod.utils;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import ru.winside.testmod.Main;

public class TestModEventHooks {

	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event) {
		if (event.entityLiving.isPotionActive(Main.JustPotion)) {
			if (event.entityLiving.worldObj.rand.nextInt(20) == 0) {
				event.entityLiving.attackEntityFrom(DamageSource.magic, 2);
			}
			if (event.entityLiving.getActivePotionEffect(Main.JustPotion).getDuration() == 0) {
				event.entityLiving.removePotionEffect(Main.JustPotion.id);
				return;
			}
		}
	}
}

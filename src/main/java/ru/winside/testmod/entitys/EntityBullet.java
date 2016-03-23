package ru.winside.testmod.entitys;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBullet extends EntityThrowable {
	int damage;

	public EntityBullet(World world) {
		super(world);
	}

	// Ќаш кастомный конструктор дл€ пули
	// par1world - мир в котором будет пул€
	// par2EntityLivingBase - тот, кто осуществил выстрел
	// par3Velocity - скорость полЄта пули
	// par4Accuracy - разброс при стрельбе
	// par5Damage - урон от попадани€
	public EntityBullet(World par1world, EntityLivingBase par2EntityLivingBase, float par3Velocity, float par4Accuracy,
			int par5Damage) {
		super(par1world, par2EntityLivingBase);
		this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, par3Velocity, par4Accuracy);
		this.damage = par5Damage;
	}

	@Override
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
		// ≈сли это произошло на сервере
		if (!this.worldObj.isRemote) {
			if (par1MovingObjectPosition.entityHit instanceof EntityLivingBase) {
				par1MovingObjectPosition.entityHit.attackEntityFrom(new DamageSource("bullet"), this.damage);
				par1MovingObjectPosition.entityHit.hurtResistantTime = 0;
			}
			this.setDead();
		}
	}
}

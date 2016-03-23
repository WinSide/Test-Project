package ru.winside.testmod.entitys;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBullet1 extends EntityThrowable {

	   private int range;
	   private int bulletdamage;
	   public Entity shootingEntity;
	   public Entity entity;


	   public EntityBullet1(World par1World) {
	      super(par1World);
	      this.setSize(0.1F, 0.1F);
	   }

	   public EntityBullet1(World par1World, EntityPlayer par2EntityLiving, int damage, float accuracy, int range) {
	      super(par1World, par2EntityLiving);
	      this.bulletdamage = damage;
	      this.shootingEntity = par2EntityLiving;
	      this.setSize(0.05F, 0.05F);
	      this.setLocationAndAngles(par2EntityLiving.posX, par2EntityLiving.posY + (double)par2EntityLiving.getEyeHeight(), par2EntityLiving.posZ, par2EntityLiving.rotationYaw, par2EntityLiving.rotationPitch);
	      this.posX -= (double)(MathHelper.cos(this.rotationYaw / 180.0F * 3.1415927F) * 0.16F);
	      this.posY -= 0.10000000149011612D;
	      this.posZ -= (double)(MathHelper.sin(this.rotationYaw / 180.0F * 3.1415927F) * 0.16F);
	      this.setPosition(this.posX, this.posY, this.posZ);
	      this.yOffset = 0.0F;
	      this.range = range;
	      this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F));
	      this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.1415927F));
	      this.motionY = (double)(-MathHelper.sin(this.rotationPitch / 180.0F * 3.1415927F));
	      this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, 100.0F, accuracy);
	   }

	   public EntityBullet1(World par1World, double par2, double par4, double par6) {
	      super(par1World, par2, par4, par6);
	   }

	   protected float getGravityVelocity() {
	      return 0.001F;
	   }

	   public void setVelocity(double par1, double par3, double par5) {
	      this.motionX = par1;
	      this.motionY = par3;
	      this.motionZ = par5;
	      if(this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
	         float f = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
	         this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / 3.141592653589793D);
	         this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, (double)f) * 180.0D / 3.141592653589793D);
	         this.prevRotationPitch = this.rotationPitch;
	         this.prevRotationYaw = this.rotationYaw;
	         this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
	      }

	   }

	   public void setArrowHeading(double par1, double par3, double par5, float par7, float par8) {
	      float f = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
	      par1 /= (double)f;
	      par3 /= (double)f;
	      par5 /= (double)f;
	      par1 += this.rand.nextGaussian() * 0.007499999832361937D * (double)par8;
	      par3 += this.rand.nextGaussian() * 0.007499999832361937D * (double)par8;
	      par5 += this.rand.nextGaussian() * 0.007499999832361937D * (double)par8;
	      par1 *= (double)par7;
	      par3 *= (double)par7;
	      par5 *= (double)par7;
	      this.motionX = par1;
	      this.motionY = par3;
	      this.motionZ = par5;
	      float f1 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
	      this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / 3.141592653589793D);
	      this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, (double)f1) * 180.0D / 3.141592653589793D);
	   }

	   protected void onImpact(MovingObjectPosition par1) {
	      if(par1.entityHit != null) {
	         int var2 = this.bulletdamage;
	         par1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)var2);
	         par1.entityHit.hurtResistantTime = 10;
	         par1.entityHit.setVelocity(0.0D, 0.0D, 0.0D);
	      }

	      if(this.worldObj.getBlock(par1.blockX, par1.blockY, par1.blockZ) == Blocks.glass || this.worldObj.getBlock(par1.blockX, par1.blockY, par1.blockZ) == Blocks.glass_pane || this.worldObj.getBlock(par1.blockX, par1.blockY, par1.blockZ) == Blocks.glowstone || this.worldObj.getBlock(par1.blockX, par1.blockY, par1.blockZ) == Blocks.stained_glass || this.worldObj.getBlock(par1.blockX, par1.blockY, par1.blockZ) == Blocks.stained_glass_pane) {
	         this.worldObj.setBlock(par1.blockX, par1.blockY, par1.blockZ, Blocks.air);
	      }

	      if(this.worldObj.getBlock(par1.blockX, par1.blockY, par1.blockZ).getMaterial() == Material.rock) { }

	      if(this.worldObj.getBlock(par1.blockX, par1.blockY, par1.blockZ) != Blocks.tallgrass && this.worldObj.getBlock(par1.blockX, par1.blockY, par1.blockZ) != Blocks.double_plant && this.worldObj.getBlock(par1.blockX, par1.blockY, par1.blockZ) != Blocks.web && this.worldObj.getBlock(par1.blockX, par1.blockY, par1.blockZ) != Blocks.vine && this.worldObj.getBlock(par1.blockX, par1.blockY, par1.blockZ) != Blocks.sapling && this.worldObj.getBlock(par1.blockX, par1.blockY, par1.blockZ) != Blocks.leaves && this.worldObj.getBlock(par1.blockX, par1.blockY, par1.blockZ) != Blocks.leaves2) { }

	   }

}

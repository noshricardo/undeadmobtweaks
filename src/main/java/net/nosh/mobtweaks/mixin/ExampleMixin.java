package net.nosh.mobtweaks.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.ZombieEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(LivingEntity.class)
public abstract class ExampleMixin {
	@Shadow public abstract EntityGroup getGroup();

	@Shadow public abstract void setHealth(float health);

	@Shadow public abstract float getMaxHealth();


	@Shadow public abstract double getAttributeBaseValue(EntityAttribute attribute);

	@Shadow public abstract AttributeContainer getAttributes();

	@Inject(at = @At("HEAD"), method = "onDeath")
	private void init(CallbackInfo info) {
		if(this.getGroup() == EntityGroup.UNDEAD){
			System.out.println("from onDeath of UNDEAD with love");
			this.setHealth(this.getMaxHealth()-10);

		}
		System.out.println("from onDeath with love");
	}
}

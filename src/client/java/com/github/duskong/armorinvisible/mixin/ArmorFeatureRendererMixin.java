package com.github.duskong.armorinvisible.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HumanoidArmorLayer.class)
public class ArmorFeatureRendererMixin<
		S extends HumanoidRenderState
		> {

	@Inject(
			method = "renderArmorPiece",
			at = @At("HEAD"),
			cancellable = true
	)
	private void armorInvisible$cancelArmorRender(
			PoseStack poseStack,
			SubmitNodeCollector submitNodeCollector,
			ItemStack itemStack,
			EquipmentSlot slot,
			int lightCoords,
			S state,
			CallbackInfo ci
	) {
		if (slot == null) return;
		if(itemStack.is(Items.ELYTRA)) return;

		Minecraft client = Minecraft.getInstance();
		if(client.player == null || state.entityType != client.player.getType()) return;
		ci.cancel();
	}
}
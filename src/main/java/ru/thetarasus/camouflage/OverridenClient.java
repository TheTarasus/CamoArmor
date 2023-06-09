package ru.thetarasus.camouflage;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.item.DyeableArmorItem;

@Environment(EnvType.CLIENT)
public class OverridenClient implements ClientModInitializer {
       @Override
       public void onInitializeClient() {
           ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((DyeableArmorItem)stack.getItem()).getColor(stack), CamoArmor.CHAIN_BOOTS);
           ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((DyeableArmorItem)stack.getItem()).getColor(stack), CamoArmor.CHAIN_LEGGINGS);
           ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((DyeableArmorItem)stack.getItem()).getColor(stack), CamoArmor.CHAIN_CHESTPLATE);
           ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((DyeableArmorItem)stack.getItem()).getColor(stack), CamoArmor.CHAIN_HELMET);

           ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((DyeableArmorItem)stack.getItem()).getColor(stack), CamoArmor.GOLD_BOOTS);
           ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((DyeableArmorItem)stack.getItem()).getColor(stack), CamoArmor.GOLD_LEGGINGS);
           ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((DyeableArmorItem)stack.getItem()).getColor(stack), CamoArmor.GOLD_CHESTPLATE);
           ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((DyeableArmorItem)stack.getItem()).getColor(stack), CamoArmor.GOLD_HELMET);

           ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((DyeableArmorItem)stack.getItem()).getColor(stack), CamoArmor.IRON_BOOTS);
           ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((DyeableArmorItem)stack.getItem()).getColor(stack), CamoArmor.IRON_LEGGINGS);
           ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((DyeableArmorItem)stack.getItem()).getColor(stack), CamoArmor.IRON_CHESTPLATE);
           ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((DyeableArmorItem)stack.getItem()).getColor(stack), CamoArmor.IRON_HELMET);

           ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((DyeableArmorItem)stack.getItem()).getColor(stack), CamoArmor.DIAMOND_BOOTS);
           ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((DyeableArmorItem)stack.getItem()).getColor(stack), CamoArmor.DIAMOND_LEGGINGS);
           ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((DyeableArmorItem)stack.getItem()).getColor(stack), CamoArmor.DIAMOND_CHESTPLATE);
           ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((DyeableArmorItem)stack.getItem()).getColor(stack), CamoArmor.DIAMOND_HELMET);

           ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((DyeableArmorItem)stack.getItem()).getColor(stack), CamoArmor.NETHERITE_BOOTS);
           ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((DyeableArmorItem)stack.getItem()).getColor(stack), CamoArmor.NETHERITE_LEGGINGS);
           ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((DyeableArmorItem)stack.getItem()).getColor(stack), CamoArmor.NETHERITE_CHESTPLATE);
           ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ((DyeableArmorItem)stack.getItem()).getColor(stack), CamoArmor.NETHERITE_HELMET);
       }
}
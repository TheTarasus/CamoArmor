package ru.thetarasus.camouflage;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;

public class DiamondDyeable extends CamouflageArmor {

    public DiamondDyeable(ArmorMaterial armorMaterial, EquipmentSlot equipmentSlot, Settings settings) {
        super(armorMaterial, equipmentSlot, settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack){
        return false;
    }

    @Override
    public int getColor(ItemStack stack) {
        CompoundTag compoundTag = stack.getSubTag("display");
        return compoundTag != null && compoundTag.contains("color", 99) ? compoundTag.getInt("color") : 0x57FFF2;
    }
}

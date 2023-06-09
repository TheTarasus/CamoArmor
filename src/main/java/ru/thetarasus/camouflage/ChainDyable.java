package ru.thetarasus.camouflage;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;

public class ChainDyable extends CamouflageArmor {


    public ChainDyable(ArmorMaterial armorMaterial, EquipmentSlot equipmentSlot, Settings settings) {
        super(armorMaterial, equipmentSlot, settings);
    }


    @Override
    public int getColor(ItemStack stack) {
        CompoundTag compoundTag = stack.getSubTag("display");
        return compoundTag != null && compoundTag.contains("color", 99) ? compoundTag.getInt("color") : 0xF9FFFE;
    }
}

package ru.thetarasus.camouflage;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

public class IronDyable extends CamouflageArmor {


    public IronDyable(ArmorMaterial armorMaterial, EquipmentSlot equipmentSlot, Settings settings) {
        super(armorMaterial, equipmentSlot, settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack){
        return false;
    }

    @Override
    public int getColor(ItemStack stack) {
        NbtCompound compoundTag = stack.getSubNbt("display");
        return compoundTag != null && compoundTag.contains("color", 99) ? compoundTag.getInt("color") : 0xF9FFFE;
    }
}

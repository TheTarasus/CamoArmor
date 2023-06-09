package ru.thetarasus.camouflage;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CamouflageArmor extends DyeableArmorItem {


    public CamouflageArmor(ArmorMaterial armorMaterial, EquipmentSlot equipmentSlot, Settings settings) {
        super(armorMaterial, equipmentSlot, settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack){
        return false;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context){
        super.appendTooltip(stack, world, tooltip, context);

        int color = this.getColor(stack);
        String set = Integer.toHexString(color);
        char[] seq = set.toCharArray();
        set = "";
        for (char ch : seq){
            set += "§" + ch;
        }
        set = "Color: " + set + "■";
        tooltip.add(Text.of(set));
    }
}

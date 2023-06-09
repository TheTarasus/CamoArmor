package ru.thetarasus.camouflage;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Lazy;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class CamoArmor implements ModInitializer {
	public static enum CustomArmorMaterials implements ArmorMaterial{
		CAMO_DIAMOND("camo_diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> {
			return Ingredient.ofItems(Items.DIAMOND);
		}),
		CAMO_CHAIN("camo_chainmail", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F, 0.0F, () -> {
			return Ingredient.ofItems(Items.IRON_INGOT);
		}),
		CAMO_IRON("camo_iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
			return Ingredient.ofItems(Items.IRON_INGOT);
		}),
		CAMO_GOLD("camo_gold", 7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> {
			return Ingredient.ofItems(Items.GOLD_INGOT);
		}),
		CAMO_NETHERITE("camo_netherite", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> {
			return Ingredient.ofItems(Items.NETHERITE_INGOT);
		});
		private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
		private final String name;
		private final int durabilityMultiplier;
		private final int[] protectionAmounts;
		private final int enchantability;
		private final SoundEvent equipSound;
		private final float toughness;
		private final float knockbackResistance;
		private final Lazy<Ingredient> repairIngredientSupplier;

		private CustomArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
			this.name = name;
			this.durabilityMultiplier = durabilityMultiplier;
			this.protectionAmounts = protectionAmounts;
			this.enchantability = enchantability;
			this.equipSound = equipSound;
			this.toughness = toughness;
			this.knockbackResistance = knockbackResistance;
			this.repairIngredientSupplier = new Lazy(repairIngredientSupplier);
		}

		public int getDurability(EquipmentSlot slot) {
			return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
		}

		public int getProtectionAmount(EquipmentSlot slot) {
			return this.protectionAmounts[slot.getEntitySlotId()];
		}

		public int getEnchantability() {
			return this.enchantability;
		}

		public SoundEvent getEquipSound() {
			return this.equipSound;
		}

		public Ingredient getRepairIngredient() {
			return (Ingredient)this.repairIngredientSupplier.get();
		}

		@Environment(EnvType.CLIENT)
		public String getName() {
			return this.name;
		}

		public float getToughness() {
			return this.toughness;
		}

		public float getKnockbackResistance() {
			return this.knockbackResistance;
		}
	}
	public static String MOD_ID = "camoarmor";


	public static Item CAMOUFLAGE = new Item(new FabricItemSettings().group(ItemGroup.COMBAT));

	public static ArmorMaterial CAMO_NETHERITE = CustomArmorMaterials.CAMO_NETHERITE;
	static DyeableArmorItem NETHERITE_HELMET = new NetheriteDyeable(CAMO_NETHERITE, EquipmentSlot.HEAD, (new Item.Settings()).group(ItemGroup.COMBAT));
	static DyeableArmorItem NETHERITE_CHESTPLATE = new NetheriteDyeable(CAMO_NETHERITE, EquipmentSlot.CHEST, (new Item.Settings()).group(ItemGroup.COMBAT));
	static DyeableArmorItem NETHERITE_LEGGINGS = new NetheriteDyeable(CAMO_NETHERITE, EquipmentSlot.LEGS, (new Item.Settings()).group(ItemGroup.COMBAT));
	static DyeableArmorItem NETHERITE_BOOTS = new NetheriteDyeable(CAMO_NETHERITE, EquipmentSlot.FEET, (new Item.Settings()).group(ItemGroup.COMBAT));


	public static ArmorMaterial CAMO_DIAMOND = CustomArmorMaterials.CAMO_DIAMOND;
	static DyeableArmorItem DIAMOND_HELMET = new DiamondDyeable(CAMO_DIAMOND, EquipmentSlot.HEAD, (new Item.Settings()).group(ItemGroup.COMBAT));
	static DyeableArmorItem DIAMOND_CHESTPLATE = new DiamondDyeable(CAMO_DIAMOND, EquipmentSlot.CHEST, (new Item.Settings()).group(ItemGroup.COMBAT));
	static DyeableArmorItem DIAMOND_LEGGINGS = new DiamondDyeable(CAMO_DIAMOND, EquipmentSlot.LEGS, (new Item.Settings()).group(ItemGroup.COMBAT));
	static DyeableArmorItem DIAMOND_BOOTS = new DiamondDyeable(CAMO_DIAMOND, EquipmentSlot.FEET, (new Item.Settings()).group(ItemGroup.COMBAT));


	public static ArmorMaterial CAMO_GOLD = CustomArmorMaterials.CAMO_GOLD;
	static DyeableArmorItem GOLD_HELMET = new GoldDyable(CAMO_GOLD, EquipmentSlot.HEAD, (new Item.Settings()).group(ItemGroup.COMBAT));
	static DyeableArmorItem GOLD_CHESTPLATE = new GoldDyable(CAMO_GOLD, EquipmentSlot.CHEST, (new Item.Settings()).group(ItemGroup.COMBAT));
	static DyeableArmorItem GOLD_LEGGINGS = new GoldDyable(CAMO_GOLD, EquipmentSlot.LEGS, (new Item.Settings()).group(ItemGroup.COMBAT));
	static DyeableArmorItem GOLD_BOOTS = new GoldDyable(CAMO_GOLD, EquipmentSlot.FEET, (new Item.Settings()).group(ItemGroup.COMBAT));


	public static ArmorMaterial CAMO_IRON = CustomArmorMaterials.CAMO_IRON;
	static DyeableArmorItem IRON_HELMET = new IronDyable(CAMO_IRON, EquipmentSlot.HEAD, (new Item.Settings()).group(ItemGroup.COMBAT));
	static DyeableArmorItem IRON_CHESTPLATE = new IronDyable(CAMO_IRON, EquipmentSlot.CHEST, (new Item.Settings()).group(ItemGroup.COMBAT));
	static DyeableArmorItem IRON_LEGGINGS = new IronDyable(CAMO_IRON, EquipmentSlot.LEGS, (new Item.Settings()).group(ItemGroup.COMBAT));
	static DyeableArmorItem IRON_BOOTS = new IronDyable(CAMO_IRON, EquipmentSlot.FEET, (new Item.Settings()).group(ItemGroup.COMBAT));

	public static ArmorMaterial CAMO_CHAIN = CustomArmorMaterials.CAMO_CHAIN;
	static DyeableArmorItem CHAIN_HELMET = new ChainDyable(CAMO_CHAIN, EquipmentSlot.HEAD, (new Item.Settings()).group(ItemGroup.COMBAT));
	static DyeableArmorItem CHAIN_CHESTPLATE = new ChainDyable(CAMO_CHAIN, EquipmentSlot.CHEST, (new Item.Settings()).group(ItemGroup.COMBAT));
	static DyeableArmorItem CHAIN_LEGGINGS = new ChainDyable(CAMO_CHAIN, EquipmentSlot.LEGS, (new Item.Settings()).group(ItemGroup.COMBAT));
	static DyeableArmorItem CHAIN_BOOTS = new ChainDyable(CAMO_CHAIN, EquipmentSlot.FEET, (new Item.Settings()).group(ItemGroup.COMBAT));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camouflage"), CAMOUFLAGE);

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camo_golden_helmet"), GOLD_HELMET);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camo_golden_chestplate"), GOLD_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camo_golden_leggings"), GOLD_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camo_golden_boots"), GOLD_BOOTS);

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camo_chainmail_helmet"), CHAIN_HELMET);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camo_chainmail_chestplate"), CHAIN_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camo_chainmail_leggings"), CHAIN_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camo_chainmail_boots"), CHAIN_BOOTS);

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camo_iron_helmet"), IRON_HELMET);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camo_iron_chestplate"), IRON_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camo_iron_leggings"), IRON_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camo_iron_boots"), IRON_BOOTS);


		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camo_diamond_helmet"), DIAMOND_HELMET);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camo_diamond_chestplate"), DIAMOND_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camo_diamond_leggings"), DIAMOND_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camo_diamond_boots"), DIAMOND_BOOTS);

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camo_netherite_helmet"), NETHERITE_HELMET);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camo_netherite_chestplate"), NETHERITE_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camo_netherite_leggings"), NETHERITE_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "camo_netherite_boots"), NETHERITE_BOOTS);


	}
}

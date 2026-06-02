///*
// * Copyright 2021 Infernal Studios
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package org.infernalstudios.miningmaster.init;
//
//import net.minecraft.Util;
//import net.minecraft.core.Holder;
//import net.minecraft.core.Registry;
//import net.minecraft.core.registries.BuiltInRegistries;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.sounds.SoundEvent;
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.util.LazyLoadedValue;
//import net.minecraft.world.item.ArmorItem;
//import net.minecraft.world.item.ArmorMaterial;
//import net.minecraft.world.item.ArmorMaterials;
//import net.minecraft.world.item.crafting.Ingredient;
//import org.infernalstudios.miningmaster.MiningMaster;
//
//import java.util.EnumMap;
//import java.util.List;
//import java.util.Map;
//import java.util.function.Supplier;
//
//public class MMArmorMaterials {
////    PARAGON("paragon", 40, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
////        map.put(ArmorItem.Type.BOOTS, 3);
////        map.put(ArmorItem.Type.LEGGINGS, 6);
////        map.put(ArmorItem.Type.CHESTPLATE, 8);
////        map.put(ArmorItem.Type.HELMET, 3);
////    }), 20, SoundEvents.ARMOR_EQUIP_DIAMOND, 4.0F, 0.0F, () -> Ingredient.EMPTY);
//    public static final Holder<ArmorMaterial> PARAGON = registerMaterial("paragon",
//        Map.of(
//                ArmorItem.Type.HELMET, 3,
//                ArmorItem.Type.CHESTPLATE, 8,
//                ArmorItem.Type.LEGGINGS, 6,
//                ArmorItem.Type.BOOTS, 3
//        ),
//        20,
//        SoundEvents.ARMOR_EQUIP_DIAMOND,
//        () -> Ingredient.EMPTY,
//        4.0F, 0.0F,
//        false
//    );
//
//    public static void init() {
//        MiningMaster.LOGGER.info("Tool/Armor materials registered");
//    };
//
////    private final String name;
////    private final int durabilityMultiplier;
////    private final int enchantability;
////    private final SoundEvent soundEvent;
////    private final float toughness;
////    private final float knockbackResistance;
////    private final LazyLoadedValue<Ingredient> repairMaterial;
////    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
////        map.put(ArmorItem.Type.BOOTS, 13);
////        map.put(ArmorItem.Type.LEGGINGS, 15);
////        map.put(ArmorItem.Type.CHESTPLATE, 16);
////        map.put(ArmorItem.Type.HELMET, 11);
////    });
////    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
//
//
////    MMArmorMaterials(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protectionFunctionForType, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial) {
////        this.name = name;
////        this.durabilityMultiplier = durabilityMultiplier;
////        this.protectionFunctionForType = protectionFunctionForType;
////        this.enchantability = enchantability;
////        this.soundEvent = soundEvent;
////        this.toughness = toughness;
////        this.knockbackResistance = knockbackResistance;
////        this.repairMaterial = new LazyLoadedValue<>(repairMaterial);
////    }
//
//
//    public static Holder<ArmorMaterial> registerMaterial(String id, Map<ArmorItem.Type, Integer> defensePoints, int enchantability, Holder<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float toughness, float knockbackResistance, boolean dyeable) {
//        List<ArmorMaterial.Layer> layers = List.of(
//                new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, id), "", dyeable)
//        );
//        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockbackResistance);
//        material = Registry.register(BuiltInRegistries.ARMOR_MATERIAL, ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, id), material);
//
//        return Holder.direct(material);
//    }
//
////    @Override
////    public int getDurabilityForType(ArmorItem.Type type) {
////        return HEALTH_FUNCTION_FOR_TYPE.get(type) * this.durabilityMultiplier;
////    }
////
////    @Override
////    public int getDefenseForType(ArmorItem.Type type) {
////        return this.protectionFunctionForType.get(type);
////    }
////
////    @Override
////    public int getEnchantmentValue() {
////        return this.enchantability;
////    }
////
////    @Override
////    public SoundEvent getEquipSound() {
////        return this.soundEvent;
////    }
////
////    @Override
////    public Ingredient getRepairIngredient() {
////        return this.repairMaterial.get();
////    }
////
////    @Override
////    public String getName() {
////        return MiningMaster.MOD_ID + ':' + this.name;
////    }
////
////    @Override
////    public float getToughness() {
////        return this.toughness;
////    }
////
////    @Override
////    public float getKnockbackResistance() {
////        return this.knockbackResistance;
////    }
//}

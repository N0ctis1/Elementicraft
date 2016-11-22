package elementicraft.common;

import java.awt.Color;
import java.util.Random;

import org.lwjgl.input.Keyboard;

import com.google.common.escape.Escapers;

import elementicraft.proxy.commonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.init.Biomes;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeOcean;
import net.minecraft.world.biome.BiomeRiver;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistry;
import net.minecraftforge.fml.common.registry.IForgeRegistryEntry;
@Mod(modid = "elementicraft",name= "Elementicraft", version="1.0.0")

public class Elementicraft {
	
	@Instance("elementicraft")
	public static Elementicraft instance;
	
	@SidedProxy(clientSide="elementicraft.proxy.clientProxy", serverSide="elementicraft.proxy.commonProxy")
	public static commonProxy proxy; 
	//déclaration des block 
	public static Block spell_table; 
	//déclaration d'item
	public static KeyBinding ping;
	public static KeyBinding pong;
	public static Item essence_feu;
	public static Item essence_eau;
	public static Item essence_terre;
	public static Item essence_air;
	public static Item essence_end;
	public static Item essence_lava;
	public static Item essence_foudre;
	public static Item essence_glace;
	public static Item essence_arcane;
	public static Item essence_lumiere;
	public static Item essence_mort;
	public static Item essence_vie;
	public static Item essence_energie;
	public static Item essence_poison;
	public static Item essence_cristal;
	public static Item essence_vapeur;
	public static Essence_Terre2 essence_terre2;
	
	public static Item mana;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//initialisation block et items
		spell_table = new TableSort(Material.ANVIL);
		essence_feu = new Essence_Feu().setUnlocalizedName("essence_feu");
		essence_eau = new Essence_Eau().setUnlocalizedName("essence_eau");
		essence_terre = new Essence_Terre().setUnlocalizedName("essence_terre");
		essence_air = new Essence_Air().setUnlocalizedName("essence_air");
		essence_end = new Essence_End().setUnlocalizedName("essence_end");
		essence_lava = new Essence_Lava().setUnlocalizedName("essence_lava");
		essence_foudre = new Essence_Foudre().setUnlocalizedName("essence_foudre");
		essence_glace = new Essence_Glace().setUnlocalizedName("essence_glace");
		essence_arcane = new Essence_Arcane().setUnlocalizedName("essence_arcane");
		essence_lumiere = new Essence_Lumiere().setUnlocalizedName("essence_lumiere");
		essence_mort = new Essence_Mort().setUnlocalizedName("essence_mort");
		essence_vie = new Essence_Vie().setUnlocalizedName("essence_vie");
		essence_energie = new Essence_Energie().setUnlocalizedName("essence_energie");
		essence_poison = new Essence_Poison().setUnlocalizedName("essence_poison");
		essence_cristal = new Essence_Cristal().setUnlocalizedName("essence_cristal");
		essence_vapeur = new Essence_Vapeur().setUnlocalizedName("essence_vapeur");
		// en test // essence_terre2 = new Essence_Terre2(null);

		//enregistrement dans l'inventaire créa
		
		//gestion de different parametre 
		
		//essence_terre.setMaxStackSize(0);
		
		
		//enregistrement dans la base de donées du jeu 
		GameRegistry.registerBlock(spell_table,"spell_table");
		GameRegistry.registerItem(essence_feu,"essence_feu");
		GameRegistry.registerItem(essence_eau,"essence_eau");
		GameRegistry.registerItem(essence_air,"essence_air");
		GameRegistry.registerItem(essence_terre,"essence_terre");
		GameRegistry.registerItem(essence_end,"essence_end");
		GameRegistry.registerItem(essence_lava,"essence_lava");
		GameRegistry.registerItem(essence_foudre,"essence_foudre");
		GameRegistry.registerItem(essence_glace,"essence_glace");
		GameRegistry.registerItem(essence_arcane,"essence_arcane");
		GameRegistry.registerItem(essence_lumiere,"essence_lumiere");
		GameRegistry.registerItem(essence_mort,"essence_mort");
		GameRegistry.registerItem(essence_vie,"essence_vie");
		GameRegistry.registerItem(essence_energie,"essence_energie");
		GameRegistry.registerItem(essence_poison,"essence_poison");
		GameRegistry.registerItem(essence_cristal,"essence_cristal");
		GameRegistry.registerItem(essence_vapeur,"essence_vapeur");
		//Drop
		MinecraftForge.EVENT_BUS.register(new DropEssence());
		// Rendu personnalisé
		proxy.registerRender();
	}
	@EventHandler
	public void Init(FMLInitializationEvent event){
		
		
		proxy.registerRender();
		// rendu de l'objet 
		
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(essence_feu, 0, new ModelResourceLocation("elementicraft:essence_feu", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(essence_eau, 0, new ModelResourceLocation("elementicraft:essence_eau", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(essence_terre, 0, new ModelResourceLocation("elementicraft:essence_terre", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(essence_air, 0, new ModelResourceLocation("elementicraft:essence_air", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(essence_end, 0, new ModelResourceLocation("elementicraft:essence_end", "inventory"));		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(essence_end, 0, new ModelResourceLocation("elementicraft:essence_end", "inventory"));		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(essence_lava, 0, new ModelResourceLocation("elementicraft:essence_lava", "inventory"));		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(essence_foudre, 0, new ModelResourceLocation("elementicraft:essence_foudre", "inventory"));		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(essence_glace, 0, new ModelResourceLocation("elementicraft:essence_glace", "inventory"));		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(essence_arcane, 0, new ModelResourceLocation("elementicraft:essence_arcane", "inventory"));		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(essence_vie, 0, new ModelResourceLocation("elementicraft:essence_vie", "inventory"));		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(essence_lumiere, 0, new ModelResourceLocation("elementicraft:essence_lumiere", "inventory"));		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(essence_mort, 0, new ModelResourceLocation("elementicraft:essence_mort", "inventory"));		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(essence_energie, 0, new ModelResourceLocation("elementicraft:essence_energie", "inventory"));		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(essence_vapeur, 0, new ModelResourceLocation("elementicraft:essence_vapeur", "inventory"));		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(essence_cristal, 0, new ModelResourceLocation("elementicraft:essence_cristal", "inventory"));		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(essence_poison, 0, new ModelResourceLocation("elementicraft:essence_poison", "inventory"));		

		//enregistrement de l'élémentaire de l'eau + oeuf spawn (couleur en �cimal) + spawn biomes
		EntityRegistry.registerModEntity(Essence_Terre2.class, "essence_terre2", 2303, this.instance, 40, 1, true);
		EntityRegistry.registerModEntity(elem_eau.class, "Elementaire_Eau", 2300, this.instance , 40, 1, true, 0xB1D4D4,0x0000FF);
		EntityRegistry.addSpawn(elem_eau.class, 10, 1, 1, EnumCreatureType.MONSTER,Biomes.BEACH);
		EntityRegistry.addSpawn(elem_eau.class, 10, 1, 1, EnumCreatureType.MONSTER, Biomes.OCEAN);
		EntityRegistry.addSpawn(elem_eau.class, 10, 1, 1, EnumCreatureType.MONSTER,Biomes.BEACH);
		EntityRegistry.addSpawn(elem_eau.class, 10, 1, 1, EnumCreatureType.MONSTER, Biomes.SWAMPLAND);
		
		EntityRegistry.registerModEntity(elem_terre.class, "Elementaire_Terre", 2301, this.instance , 40, 1, true, 0xc5b35b,0x695132);
		EntityRegistry.addSpawn(elem_terre.class, 10, 5, 10, EnumCreatureType.MONSTER, Biomes.PLAINS);
		EntityRegistry.addSpawn(elem_terre.class, 10, 5, 10, EnumCreatureType.MONSTER, Biomes.STONE_BEACH);
		EntityRegistry.addSpawn(elem_terre.class, 10, 5, 10, EnumCreatureType.MONSTER, Biomes.EXTREME_HILLS);
		EntityRegistry.addSpawn(elem_terre.class, 10, 5, 10, EnumCreatureType.MONSTER, Biomes.MESA);
		EntityRegistry.addSpawn(elem_terre.class, 10, 5, 10, EnumCreatureType.MONSTER, Biomes.DESERT);
		EntityRegistry.addSpawn(elem_terre.class, 10, 5, 10, EnumCreatureType.MONSTER, Biomes.SAVANNA);
		EntityRegistry.registerModEntity(elem_feu.class, "Elementaire_Feu", 2302, this.instance , 40, 1, true, 0xe7a251,0x9d2525);
		EntityRegistry.addSpawn(elem_feu.class, 10, 5, 10, EnumCreatureType.MONSTER, Biomes.HELL);
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){

	}


}

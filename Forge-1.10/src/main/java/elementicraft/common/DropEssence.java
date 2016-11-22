package elementicraft.common;

import java.util.Collection;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;

import org.lwjgl.input.Keyboard;



public class DropEssence {
	private static KeyBinding keyBindTest;
	private ItemStack terre;
	//Drop random des items avec une certaine probalité
	@SubscribeEvent
	public void DropTerre(LivingDropsEvent event){
		if(!(event.getEntity() instanceof EntityCreeper|| event.getEntity() instanceof EntitySpider || event.getEntity() instanceof EntityCaveSpider || event.getEntity() instanceof EntitySpider || event.getEntity() instanceof EntitySilverfish || event.getEntity() instanceof EntitySpider || event.getEntity() instanceof EntityWitch )){
			return;
		}
		Random random = new Random();
		int drop = random.nextInt(20);
		
		Essence_Terre2 essence = new Essence_Terre2(event.getEntity().worldObj, event.getEntity().posX,event.getEntity().posY,event.getEntity().posZ, 1);
		
		//if(drop==1){
			 ItemStack stack = new ItemStack (Elementicraft.essence_terre);
			EntityItem dropable = new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, stack);
			event.getDrops().add(dropable);		
			
			
			
			//}
		
	}
	@SubscribeEvent
	public void DropEau(LivingDropsEvent event){
		if(!(event.getEntity() instanceof EntityPolarBear|| event.getEntity() instanceof EntityGuardian || event.getEntity() instanceof EntitySlime || event.getEntity() instanceof EntityWitch)){
			return;
		}
		Random random = new Random();
		int drop = random.nextInt(20);
		if(drop==1){
			ItemStack stack = new ItemStack (Elementicraft.essence_eau);
			EntityItem dropable = new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, stack);
			event.getDrops().add(dropable);
		}
	}
	
	
	@SubscribeEvent
	public void DropFeu(LivingDropsEvent event){
		if(!(event.getEntity() instanceof EntityBlaze|| event.getEntity() instanceof EntityMagmaCube || event.getEntity() instanceof EntityPigZombie || event.getEntity() instanceof EntityWitch)){
			return;
		}
		Random random = new Random();
		int drop = random.nextInt(20);
		if(drop==1){
			ItemStack stack = new ItemStack (Elementicraft.essence_feu);
			EntityItem dropable = new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, stack);
			event.getDrops().add(dropable);
		}
	}
	
	
	@SubscribeEvent
	public void DropAir(LivingDropsEvent event){
		if(!(event.getEntity() instanceof EntityGhast|| event.getEntity() instanceof EntityBat || event.getEntity() instanceof EntityWitch )){
			return;
		}
		Random random = new Random();
		int drop = random.nextInt(20);
		if(drop==1){
			ItemStack stack = new ItemStack (Elementicraft.essence_air);
			EntityItem dropable = new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, stack);
			event.getDrops().add(dropable);		}
	}
	
	
	@SubscribeEvent
	public void DropEnd(LivingDropsEvent event){
		if(!(event.getEntity() instanceof EntityEnderman|| event.getEntity() instanceof EntityEndermite || event.getEntity() instanceof EntityShulker || event.getEntity() instanceof EntitySkeleton || event.getEntity() instanceof EntityZombie || event.getEntity() instanceof EntityWitch  )){
			return;
		}
		Random random = new Random();
		int drop = random.nextInt(20);
		if(drop==1){
			ItemStack stack = new ItemStack (Elementicraft.essence_end);
			EntityItem dropable = new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, stack);
			event.getDrops().add(dropable);
		}
	}
	
	/*	
	@SubscribeEvent
	public void DropMana(HarvestDropsEvent event){
		if(event.getHarvester() != null){
	
			if(event.getState().getBlock().equals(Blocks.LIT_REDSTONE_ORE)|| event.getState().getBlock().equals(Blocks.EMERALD_ORE)|| event.getState().getBlock().equals(Blocks.COAL_ORE)|| event.getState().getBlock().equals(Blocks.DIAMOND_ORE)||event.getState().getBlock().equals(Blocks.QUARTZ_ORE)){
				Random random = new Random();
				int drop = random.nextInt(4);
				if(drop==1){
				ItemStack mana = new ItemStack(Elementicraft.mana);
				event.getDrops().add(mana);
				}
			}
		}
		
	}*/
	/*
	@SubscribeEvent
	public void OnCollideItem(EntityItemPickupEvent event){
		System.out.println("objet ramasser");
		ItemStack eau = new ItemStack(Elementicraft.essence_eau);
		terre= new ItemStack(Elementicraft.essence_terre);
		ItemStack feu = new ItemStack(Elementicraft.essence_feu);
		
		ItemStack air = new ItemStack(Elementicraft.essence_air);
		ItemStack end = new ItemStack(Elementicraft.essence_end);
		int T=terre.getItem().getIdFromItem(Elementicraft.essence_terre);
		System.out.println(event.getItem().getEntityItem().getItem().getIdFromItem(Elementicraft.essence_terre));
		System.out.println(T);
			//removeItem(event.getEntityPlayer(), terre);
		if(event.getItem().getEntityItem().getItem().getIdFromItem(Elementicraft.essence_terre) == T ){
			System.out.println("Essence de terre detecter");
			
			//event.setCanceled(true);
			event.getItem().setDead();
			
			}
		
		
		
	}
	   @SubscribeEvent
	   public void onKeyInput(InputEvent.KeyInputEvent event) {
	       if(Elementicraft.ping.isPressed())
	           System.out.println("ping");
	       if(Elementicraft.pong.isPressed())
	           System.out.println("pong");
	   }
	
	

	
	public void removeItem(EntityPlayer ep, ItemStack removeitem) {
		IInventory inv = ep.inventory;
		for(int i=0; i < inv.getSizeInventory(); i++)
		{
			if(inv.getStackInSlot(i) != null)
			{
				ItemStack j = inv.getStackInSlot(i);
				if(j.getItem() != null && j.getItem() == removeitem.getItem())
				{
					inv.setInventorySlotContents(i, null);
				}
			}
		}
	}*/
}

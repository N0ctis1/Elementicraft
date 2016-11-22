package elementicraft.proxy;

import elementicraft.common.Elementicraft;
import elementicraft.common.Essence_Terre2;
import elementicraft.common.elem_eau;
import elementicraft.common.elem_feu;
import elementicraft.common.elem_terre;
import elementicraft.common.elem_test;
import elementicraft.client.earth_elemental;
import elementicraft.client.fire_elemental;
import elementicraft.client.model_elem_test;
import elementicraft.client.water_elemental;
import elementicraft.commons.Render_Essence_Terre2;
import elementicraft.commons.render_eau;
import elementicraft.commons.render_feu;
import elementicraft.commons.render_terre;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class clientProxy extends commonProxy {

	@Override
	public void registerRender(){
		//Rendu 3D coté client (En jeu)
		RenderingRegistry.registerEntityRenderingHandler(elem_eau.class, new render_eau (new water_elemental(),0.5F ));
		RenderingRegistry.registerEntityRenderingHandler(elem_terre.class, new render_terre (new earth_elemental(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(elem_feu.class, new render_feu (new fire_elemental(),0.5F ));
		RenderingRegistry.registerEntityRenderingHandler(Essence_Terre2.class, new Render_Essence_Terre2 (Minecraft.getMinecraft().getRenderManager()));

	}

}

package elementicraft.common;

import elementicraft.common.MCACommonLibrary.IMCAnimatedEntity;
import elementicraft.common.MCACommonLibrary.animation.AnimationHandler;
import elementicraft.common.animations.New.AnimationHandlerNew;

import net.minecraft.entity.EntityCreature;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class elem_terre extends EntityCreature implements IMCAnimatedEntity {
	protected AnimationHandler animHandler = new AnimationHandlerNew(this);
	public elem_terre(World par1World) {
		super(par1World);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
	}
	
	@Override
	public AnimationHandler getAnimationHandler() {
		return animHandler;
	}

	@Override
	public void onUpdate()
	{
            super.onUpdate();
        }

	@Override
	public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
		super.readEntityFromNBT(nbttagcompound);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		super.writeEntityToNBT(nbttagcompound);
	}
}
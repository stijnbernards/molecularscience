package molecularscience.api;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayer implements IExtendedEntityProperties
{
	
	public final static String EXT_PROP_NAME = "ExtendedPlayer";
	
	private final EntityPlayer player;
	
	private static String researches;
	private static String Minerals;
	
	public ExtendedPlayer(EntityPlayer player){
		this.player = player;
		if(this.Minerals == null){
			this.Minerals = "hoi,";
		}
		if(this.researches == null){
			this.researches = "hoi,";
		}
	}
	
	public static final void register(EntityPlayer player){
		player.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer(player));
	}

	public static final ExtendedPlayer get(EntityPlayer player){
		return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}


	@Override
	public void saveNBTData(NBTTagCompound compound){	
		NBTTagCompound properties = new NBTTagCompound();

		properties.setString("researched", this.researches);
		properties.setString("minerals", this.Minerals);
		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound){
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.researches = properties.getString("researched");
		this.Minerals = properties.getString("minerals");
	}
	
	@Override
	public void init(Entity entity, World world){}

	public static void mineralResearch(String mineral)
	{
		StringBuilder sb = new StringBuilder();
		if(Minerals.contains(mineral)){
			String[] minerals = Minerals.split(",");
			for(int i = 0; i < minerals.length; i++){
				if(minerals[i].contains(mineral)){
					String[] Phase = minerals[i].split(" ");
					int phasenow = Integer.parseInt(Phase[1]);
					if(phasenow != 6){
						phasenow++;
						minerals[i] = mineral + " " + phasenow + ",";
						break;
					}
				}
			}
			for(String m: minerals){
				sb.append(m);
				sb.append(",");
			}
			Minerals = sb.toString();
		}else{
			Minerals = Minerals + mineral + " " + "0,";
		}
	}
	
	public static int getmineralresearchphase(String mineral){
		int Phasenow;
		if(Minerals.contains(mineral)){
			String[] minerals = Minerals.split(",");
			for(String m: minerals){
				if(m.contains(mineral)){
					String[] Phase = m.split(" ");
					Phasenow = Integer.parseInt(Phase[1]);
					return Phasenow;
				}
			}
		}
		return 0;
	}
	
	public static void Research(String item)
	{
		item = item + ",";
		researches = researches + item;
	}
	
	public static boolean IsResearched(String item){
		if(researches != null){
			String[] researched = researches.split(",");
			for(String p: researched){
				if(p.equalsIgnoreCase(item)){
					return true;
				}
			}
		}
		return false;
	}
}
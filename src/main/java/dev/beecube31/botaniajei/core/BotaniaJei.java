package dev.beecube31.botaniajei.core;

import dev.beecube31.botaniajei.Tags;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
		modid = Tags.MODID,
		version = Tags.VERSION,
		name = Tags.MODNAME,
		acceptedMinecraftVersions = "[1.12.2]",
		dependencies = "required-after:mixinbooter@[8.3,);required-after:botania"
)
public class BotaniaJei {
	public static BotaniaJei instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		BotaniaJei.instance = this;
		MinecraftForge.EVENT_BUS.register(instance);
	}
}
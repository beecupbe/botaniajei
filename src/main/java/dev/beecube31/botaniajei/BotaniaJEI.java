package dev.beecube31.botaniajei;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod("botaniajei")
public class BotaniaJEI {

    public BotaniaJEI() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}

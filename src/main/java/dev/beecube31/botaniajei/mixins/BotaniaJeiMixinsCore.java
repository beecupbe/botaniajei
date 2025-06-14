package dev.beecube31.botaniajei.mixins;

import com.google.common.collect.ImmutableList;
import dev.beecube31.botaniajei.core.ModsChecker;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import zone.rong.mixinbooter.ILateMixinLoader;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@IFMLLoadingPlugin.MCVersion(ForgeVersion.mcVersion)
@IFMLLoadingPlugin.Name("BotaniaJEIPlugin")
@Optional.Interface(iface = "zone.rong.mixinbooter.ILateMixinLoader", modid = "mixinbooter")
public class BotaniaJeiMixinsCore implements IFMLLoadingPlugin, ILateMixinLoader {
	public static final String MIXIN_PATH = "mixins.botaniajei.%s.json";

	@Override
	public String[] getASMTransformerClass() {
		return new String[0];
	}

	@Override
	public String getModContainerClass() {
		return null;
	}

	@Nullable
	@Override
	public String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {}

	@Override
	public String getAccessTransformerClass() {
		return null;
	}

	@Override
	@Optional.Method(modid = "mixinbooter")
	public List<String> getMixinConfigs() {
		var mixins = new ArrayList<String>();

		mixins.add("mixins.botaniajei.json");
		mixins.add(String.format(MIXIN_PATH, "core"));

		if (ModsChecker.BOTANIA_TWEAKS_LOADED) {
			mixins.add(String.format(MIXIN_PATH, "botania_tweaks"));
		}

		return ImmutableList.copyOf(mixins);
	}
}
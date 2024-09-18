package kaptainwutax.biomeutils.source;

import kaptainwutax.biomeutils.biome.Biome;
import kaptainwutax.mcutils.state.Dimension;
import kaptainwutax.mcutils.util.pos.BPos;
import kaptainwutax.mcutils.version.MCVersion;

public abstract class BiomeSource {
	private final MCVersion version;
	private final long worldSeed;

	public BiomeSource(MCVersion version, long worldSeed) {
		this.version = version;
		this.worldSeed = worldSeed;
	}

	public static Factory factory(Dimension dimension) {
		if(dimension == Dimension.OVERWORLD) return OverworldBiomeSource::new;
		else if(dimension == Dimension.NETHER) return NetherBiomeSource::new;
		else if(dimension == Dimension.END) return EndBiomeSource::new;
		return null;
	}

	public static BiomeSource of(Dimension dimension, MCVersion version, long worldSeed) {
		Factory factory = factory(dimension);
		return factory == null ? null : factory.create(version, worldSeed);
	}

	public MCVersion getVersion() {
		return this.version;
	}

	public long getWorldSeed() {
		return this.worldSeed;
	}

	public abstract Dimension getDimension();

	public abstract Biome getBiome(BPos bpos);

	public abstract Biome getBiome(int x, int y, int z);

	public abstract Biome getBiomeForNoiseGen(int x, int y, int z);

	@FunctionalInterface
	public interface Factory {
		BiomeSource create(MCVersion version, long worldSeed);
	}

}

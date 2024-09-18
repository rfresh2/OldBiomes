package kaptainwutax.mcutils.rand.seed;

import kaptainwutax.mcutils.util.data.StringUnhasher;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.function.Predicate;

public final class WorldSeed {
	/**
	 * Checks if the given world seed can be represented as a string.
	 *
	 * @see String#hashCode()
	 * @see WorldSeed#toString(long, StringUnhasher.Config, Predicate)
	 */
	public static boolean isString(long worldSeed) {
		return (int) worldSeed == worldSeed;
	}

	/**
	 * Converts a world seed to string equivalents matching the config requirements.
	 * A predicate is provided to stop the search early if the search target was found.
	 *
	 * @see String#hashCode()
	 * @see WorldSeed#isString(long)
	 */
	public static void toString(long worldSeed, StringUnhasher.Config config, Predicate<String> continueSearching) {
		if (isString(worldSeed)) {
			StringUnhasher.unhash((int) worldSeed, config, continueSearching);
		}
	}

	/**
	 * Converts the given world seed to it's truncated sha256 value. This is equivalent
	 * to the hashed seed the server sends to the client since 1.15.
	 *
	 * @see WorldSeed#fromHash(long, long)
	 */
	public static long toHash(long worldSeed) {
		MessageDigest digest;

		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return worldSeed;
		}

		byte[] bytes = new byte[8];

		for (int i = 0; i < 8; i++) {
			bytes[i] = (byte) (worldSeed & 0xFFL);
			worldSeed >>>= 8;
		}

		bytes = digest.digest(bytes);
		long hashedWorldSeed = bytes[0] & 0xFFL;

		for (int i = 1; i < 8; i++) {
			hashedWorldSeed |= (bytes[i] & 0xFFL) << (i << 3);
		}

		return hashedWorldSeed;
	}

}

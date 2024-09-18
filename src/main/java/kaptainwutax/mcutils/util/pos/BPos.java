package kaptainwutax.mcutils.util.pos;

import kaptainwutax.mcutils.util.math.Vec3i;

@SuppressWarnings("unused")
public class BPos extends Vec3i {

	public static final BPos ORIGIN = new BPos(0, 0, 0);

	public BPos(int x, int y, int z) {
		super(x, y, z);
	}

	public BPos(Vec3i vec3i) {
		super(vec3i.getX(), vec3i.getY(), vec3i.getZ());
	}

	public BPos add(BPos pos) {
		return this.add(pos.getX(), pos.getY(), pos.getZ());
	}

	public BPos subtract(BPos pos) {
		return this.subtract(pos.getX(), pos.getY(), pos.getZ());
	}

	public BPos shl(int amount) {
		return this.shl(amount, amount, amount);
	}

	public BPos shr(int amount) {
		return this.shr(amount, amount, amount);
	}

	public BPos add(int x, int y, int z) {
		return new BPos(this.getX() + x, this.getY() + y, this.getZ() + z);
	}

	public BPos subtract(int x, int y, int z) {
		return new BPos(this.getX() - x, this.getY() - y, this.getZ() - z);
	}

	public BPos shl(int bx, int by, int bz) {
		return new BPos(this.getX() << bx, this.getY() << by, this.getZ() << bz);
	}

	public BPos shr(int bx, int by, int bz) {
		return new BPos(this.getX() >> bx, this.getY() >> by, this.getZ() >> bz);
	}

	public BPos toChunkCorner() {
		return new BPos(this.getX() & -16, this.getY(), this.getZ() & -16);
	}
}

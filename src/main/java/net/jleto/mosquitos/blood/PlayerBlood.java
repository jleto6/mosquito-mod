package net.jleto.mosquitos.blood;

import net.minecraft.nbt.CompoundTag;

public class PlayerBlood {
    private int blood;
    private final int MIN_BLOOD = 0;
    private final int MAX_BLOOD = 10;

    public int getThirst() {
        return blood;
    }

    public void addThirst(int add) {
        this.blood = Math.min(blood + add, MAX_BLOOD);
    }

    public void subThirst(int sub) {
        this.blood = Math.max(blood - sub, MIN_BLOOD);
    }

    public void copyFrom(PlayerBlood source) {
        this.blood = source.blood;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("blood", blood);
    }

    public void loadNBTData(CompoundTag nbt) {
        blood = nbt.getInt("blood");
    }
}
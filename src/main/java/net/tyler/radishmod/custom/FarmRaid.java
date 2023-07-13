/**package net.tyler.radishmod.custom;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.raid.Raid;
import net.minecraft.world.World;
import net.tyler.radishmod.entity.custom.FarmRaiderEntity;

import java.util.*;

public class FarmRaid {
    private static final Text EVENT_TEXT = Text.translatable("event.radishmod.farmraid");
    private static final Text VICTORY_SUFFIX_TEXT = Text.translatable("event.radishmod.farmraid");
    private static final Text DEFEAT_SUFFIX_TEXT = Text.translatable("event.radishmod.farmraid");
    private static final Text VICTORY_TITLE = EVENT_TEXT.copy().append(" - ").append(VICTORY_SUFFIX_TEXT);
    private static final Text DEFEAT_TITLE = EVENT_TEXT.copy().append(" - ").append(DEFEAT_SUFFIX_TEXT);

    private final Map<Integer, FarmRaiderEntity> waveToCaptain = Maps.newHashMap();
    private final Map<Integer, Set<FarmRaiderEntity>> waveToFarmRaiders = Maps.newHashMap();
    private final Set<UUID> heroesOfTheFarm = Sets.newHashSet();
    private long ticksActive;
    private BlockPos center;
    private final ServerWorld world;
    private boolean started;
    private final int id;
    private float totalHealth;
    private boolean active;
    private int wavesSpawned;
    private final ServerBossBar bar = new ServerBossBar(EVENT_TEXT, BossBar.Color.GREEN, BossBar.Style.NOTCHED_10);
    private int postRaidTicks;
    private int preRaidTicks;
    private final Random random = Random.create();
    private final int waveCount;
    private Status status;

    // Creates a new raid while world is running
    public FarmRaid (int id, ServerWorld world, BlockPos pos) {
        this.id = id;
        this.world = world;
        this.active = true;
        this.preRaidTicks = 300;
        this.bar.setPercent(0.0f);
        this.center = pos;
        this.waveCount = this.getMaxWaves(world.getDifficulty());
        this.status = Status.ONGOING;
    }

    // Creates raid from stored nbt data when world is loaded
    public FarmRaid (ServerWorld world, NbtCompound nbt) {

    }

    public boolean isFinished() { return this.hasWon() || this.hasLost(); }

    public boolean isPreRaid() { return this.hasSpawned() && this.getRaiderCount() == 0 && this.preRaidTicks > 0; }

    public boolean hasSpawned() { return this.wavesSpawned > 0; }

    public boolean hasStopped() { return this.status == Status.STOPPED; }

    public boolean hasWon() { return this.status == Status.VICTORY; }

    public boolean hasLost() { return this.status == Status.LOSS; }

    public float getTotalHealth() { return this.totalHealth; }

    public Set<FarmRaiderEntity> getAllRaiders() {
        HashSet<FarmRaiderEntity> set = Sets.newHashSet();
        for (Set<FarmRaiderEntity> set2 : this.waveToFarmRaiders.values()) {
            set.addAll(set2);
        }
        return set;
    }

    public World getWorld() { return this.world; }

    public boolean hasStarted() { return this.started; }

    public int getGroupsSpawned() { return this.wavesSpawned; }

    static enum Status {
        ONGOING,
        VICTORY,
        LOSS,
        STOPPED;

        private static final Raid.Status[] VALUES;

        static Raid.Status fromName(String name) {
            for (Raid.Status status : VALUES) {
                if (!name.equalsIgnoreCase(status.name())) continue;
                return status;
            }
            return ONGOING;
        }

        public String getName() {
            return this.name().toLowerCase(Locale.ROOT);
        }

        static {
            VALUES = Raid.Status.values();
        }
    }
}
**/
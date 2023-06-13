package net.tyler.radishmod.custom;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.raid.Raid;
import net.tyler.radishmod.entity.custom.FarmRaiderEntity;

import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

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

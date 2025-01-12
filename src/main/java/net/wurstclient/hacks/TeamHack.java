package net.wurstclient.hacks;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.wurstclient.Category;
import net.wurstclient.SearchTags;
import net.wurstclient.events.UpdateListener;
import net.wurstclient.hack.Hack;
import net.wurstclient.util.FakePlayerEntity;

import java.util.HashMap;

@SearchTags({"team"})
public final class TeamHack extends Hack implements UpdateListener
{
    public HashMap<PlayerEntity, Integer> teams = new HashMap<>();
    public PlayerEntity player = MC.player;

    public TeamHack()
    {
        super("Team");
        setCategory(Category.COMBAT);
    }

    @Override
    protected void onEnable()
    {
        EVENTS.add(UpdateListener.class, this);
    }

    @Override
    protected void onDisable()
    {
        EVENTS.remove(UpdateListener.class, this);
    }

    @Override
    public void onUpdate()
    {
        HashMap<PlayerEntity, Integer> teamCache = new HashMap<>();
        player = MC.player;

        for(PlayerEntity e : MC.world.getPlayers())
        {
            if (e.isRemoved() && e.getHealth() <= 0)
                continue;
            if (e instanceof FakePlayerEntity)
                continue;

            ItemStack helmet = e.getEquippedStack(EquipmentSlot.HEAD);

            if (helmet.getItem() == Items.LEATHER_HELMET) {
                NbtCompound tag = helmet.getOrCreateSubNbt("display");

                if (tag.contains("color")) {
                    teamCache.put(e, tag.getInt("color"));
                }
            }
        }

        teams = teamCache;
    }

    public Integer getTeamColor(PlayerEntity e) {
        return teams.get(e);
    }

    public Integer getMyTeamColor() {
        return teams.get(player);
    }

    public boolean isTeammate(PlayerEntity e) {
        if (teams.get(e) == null || teams.get(player) == null)
            return false;

        return teams.get(e).equals(teams.get(player));
    }

    public boolean isOpponent(PlayerEntity e) {
        if (teams.get(e) == null || teams.get(player) == null)
            return false;

        return !teams.get(e).equals(teams.get(player));
    }

    public float[] toRGB(int color) {
        // 将颜色值转换为 0 到 255 的红、绿、蓝三个分量
        float red = ((color >> 16) & 0xFF) / 255.0f;
        float green = ((color >> 8) & 0xFF) / 255.0f;
        float blue = (color & 0xFF) / 255.0f;

        return new float[]{red, green, blue};
    }
}
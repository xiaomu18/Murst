package net.wurstclient.commands;

import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.util.StringHelper;
import net.wurstclient.command.CmdException;
import net.wurstclient.command.Command;
import net.wurstclient.util.ChatUtils;

public final class PlayerListCmd extends Command {
    public PlayerListCmd() {
        super("playerlist", "Show the List Of Online Players", ".playerlist");
    }

    @Override
    public void call(String[] args) throws CmdException {
        for(PlayerListEntry info : MC.player.networkHandler.getPlayerList())
        {
            String name = info.getProfile().getName();
            name = StringHelper.stripTextFormat(name);

            ChatUtils.message(name + "  GameMode: " + info.getGameMode());
        }
    }
}
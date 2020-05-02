package pw.cinque.timechanger.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import pw.cinque.timechanger.TimeChanger;
import pw.cinque.timechanger.TimeType;

public class CommandResetTime extends CommandBase {
    private final Minecraft mc;

    public CommandResetTime() {
        this.mc = Minecraft.getMinecraft();
    }

    public String getName() {
        return "resettime";
    }

    public String getUsage(final ICommandSender sender) {
        return "/resettime";
    }

    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        TimeChanger.TIME_TYPE = TimeType.VANILLA;
        sender.sendMessage(new TextComponentString(ChatFormatting.GREEN + "Now using vanilla time."));

    }

    public int getRequiredPermissionLevel() {
        return 0;
    }
}

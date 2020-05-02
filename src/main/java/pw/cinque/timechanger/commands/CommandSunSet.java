package pw.cinque.timechanger.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import pw.cinque.timechanger.TimeChanger;
import pw.cinque.timechanger.TimeType;

public class CommandSunSet extends CommandBase {
    private final Minecraft mc;

    public CommandSunSet() {
        this.mc = Minecraft.getMinecraft();
    }

    public String getName() {
        return "sunset";
    }

    public String getUsage(final ICommandSender sender) {
        return "/sunset";
    }

    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        TimeChanger.TIME_TYPE = TimeType.SUNSET;
        sender.sendMessage(new TextComponentString(ChatFormatting.GREEN + "Time set to sunset."));
    }

    public int getRequiredPermissionLevel() {
        return 0;
    }
}

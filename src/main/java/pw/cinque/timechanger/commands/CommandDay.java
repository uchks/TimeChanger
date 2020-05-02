package pw.cinque.timechanger.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import pw.cinque.timechanger.TimeChanger;
import pw.cinque.timechanger.TimeType;

public class CommandDay extends CommandBase {
    private final Minecraft mc;

    public CommandDay() {
        this.mc = Minecraft.getMinecraft();
    }

    public String getName() {
        return "day";
    }

    public String getUsage(final ICommandSender sender) {
        return "/day";
    }

    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        TimeChanger.TIME_TYPE = TimeType.DAY;
        sender.sendMessage(new TextComponentString(ChatFormatting.GREEN + "Time set to day."));
    }

    public int getRequiredPermissionLevel() {
        return 0;
    }
}

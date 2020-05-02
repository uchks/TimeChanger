package pw.cinque.timechanger.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import org.apache.commons.lang3.math.NumberUtils;
import pw.cinque.timechanger.TimeChanger;
import pw.cinque.timechanger.TimeType;

public class CommandFastTime extends CommandBase {
    private final Minecraft mc;

    public CommandFastTime() {
        this.mc = Minecraft.getMinecraft();
    }

    public String getName() {
        return "fasttime";
    }

    public String getUsage(final ICommandSender sender) {
        return "/fasttime <multiplier>";
    }

    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(new TextComponentString(ChatFormatting.RED + "Please use /fasttime <multiplier>!"));
            return;
        }
        final double multiplier = NumberUtils.toDouble(args[0], -1.0);
        if (multiplier < 0.0) {
            sender.sendMessage(new TextComponentString(ChatFormatting.RED + "Invalid multiplier!"));
            return;
        }
        TimeChanger.TIME_TYPE = TimeType.FAST;
        TimeChanger.fastTimeMultiplier = multiplier;
        sender.sendMessage(new TextComponentString(ChatFormatting.GREEN + "Time set to fast (" + multiplier + ")"));

    }

    public int getRequiredPermissionLevel() {
        return 0;
    }
}

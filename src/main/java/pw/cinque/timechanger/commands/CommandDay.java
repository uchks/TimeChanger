package pw.cinque.timechanger.commands;

import net.minecraft.client.*;
import net.minecraft.command.*;
import pw.cinque.timechanger.*;
import net.minecraft.util.*;

public class CommandDay extends CommandBase
{
    private Minecraft mc;
    
    public CommandDay() {
        this.mc = Minecraft.getMinecraft();
    }
    
    public String getCommandName() {
        return "day";
    }
    
    public String getCommandUsage(final ICommandSender sender) {
        return "/day";
    }
    
    public void processCommand(final ICommandSender sender, final String[] args) {
        TimeChanger.TIME_TYPE = TimeType.DAY;
        sender.addChatMessage(new ChatComponentText("Time set to day.").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    public boolean canCommandSenderUseCommand(final ICommandSender sender) {
        return true;
    }
}

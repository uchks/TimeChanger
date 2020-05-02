package pw.cinque.timechanger;

import net.minecraftforge.fml.common.*;
import net.minecraft.client.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.client.*;
import net.minecraft.command.*;
import pw.cinque.timechanger.commands.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.client.network.*;
import net.minecraft.network.*;
import net.minecraftforge.fml.common.eventhandler.*;

@Mod(name = "TimeChanger", modid = "timechanger", version = "1.0", acceptedMinecraftVersions = "1.8.9")
public class TimeChanger
{
    public static TimeType TIME_TYPE;
    public static double fastTimeMultiplier;
    private Minecraft mc;
    
    public TimeChanger() {
        this.mc = Minecraft.getMinecraft();
    }
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand((ICommand)new CommandDay());
        ClientCommandHandler.instance.registerCommand((ICommand)new CommandNight());
        ClientCommandHandler.instance.registerCommand((ICommand)new CommandSunSet());
        ClientCommandHandler.instance.registerCommand((ICommand)new CommandResetTime());
        ClientCommandHandler.instance.registerCommand((ICommand)new CommandFastTime());
        MinecraftForge.EVENT_BUS.register((Object)this);
    }
    
    @SubscribeEvent
    public void onClientTick(final TickEvent.ClientTickEvent event) {
        if (this.mc.theWorld != null) {
            final INetHandler parent = this.mc.thePlayer.sendQueue.getNetworkManager().getNetHandler();
            if (!(parent instanceof TimeChangerNetHandler)) {
                this.mc.thePlayer.sendQueue.getNetworkManager().setNetHandler((INetHandler)new TimeChangerNetHandler((NetHandlerPlayClient)parent));
            }
            if (TimeChanger.TIME_TYPE == TimeType.FAST) {
                this.mc.theWorld.setWorldTime((long)(System.currentTimeMillis() * TimeChanger.fastTimeMultiplier % 24000.0));
            }
        }
    }
    
    static {
        TimeChanger.TIME_TYPE = TimeType.VANILLA;
        TimeChanger.fastTimeMultiplier = 1.0;
    }
}

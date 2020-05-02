package pw.cinque.timechanger;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.INetHandler;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import pw.cinque.timechanger.commands.*;

@Mod(name = "TimeChanger", modid = "timechanger", version = "1.0", acceptedMinecraftVersions = "[1.12, 1.12.2]")
public class TimeChanger {
    public static TimeType TIME_TYPE;
    public static double fastTimeMultiplier;

    static {
        TimeChanger.TIME_TYPE = TimeType.VANILLA;
        TimeChanger.fastTimeMultiplier = 1.0;
    }

    private final Minecraft mc;

    public TimeChanger() {
        this.mc = Minecraft.getMinecraft();
    }

    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new CommandDay());
        ClientCommandHandler.instance.registerCommand(new CommandNight());
        ClientCommandHandler.instance.registerCommand(new CommandSunSet());
        ClientCommandHandler.instance.registerCommand(new CommandResetTime());
        ClientCommandHandler.instance.registerCommand(new CommandFastTime());
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onClientTick(final TickEvent.ClientTickEvent event) {
        if (this.mc.world != null) {
            final INetHandler parent = this.mc.player.connection.getNetworkManager().getNetHandler();
            if (!(parent instanceof TimeChangerNetHandler)) {
                this.mc.player.connection.getNetworkManager().setNetHandler(new TimeChangerNetHandler((NetHandlerPlayClient) parent));
            }
            if (TimeChanger.TIME_TYPE == TimeType.FAST) {
                this.mc.world.setWorldTime((long) (System.currentTimeMillis() * TimeChanger.fastTimeMultiplier % 24000.0));
            }
        }
    }
}

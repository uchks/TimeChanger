package pw.cinque.timechanger;

import net.minecraft.client.network.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import java.lang.reflect.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import net.minecraft.network.play.server.*;

public class TimeChangerNetHandler extends NetHandlerPlayClient
{
    private NetHandlerPlayClient parent;
    
    public TimeChangerNetHandler(final NetHandlerPlayClient parent) {
        super(Minecraft.getMinecraft(), getGuiScreen(parent), parent.getNetworkManager(), parent.getGameProfile());
        this.parent = parent;
    }
    
    private static GuiScreen getGuiScreen(final NetHandlerPlayClient parent) {
        for (final Field field : parent.getClass().getDeclaredFields()) {
            if (field.getType().equals(GuiScreen.class)) {
                field.setAccessible(true);
                try {
                    return (GuiScreen)field.get(parent);
                }
                catch (Exception e) {
                    return null;
                }
            }
        }
        return null;
    }
    
    public void onNetworkTick() {
        ((TimeChangerNetHandler)this.parent).onNetworkTick();
    }
    
    public void handleJoinGame(final S01PacketJoinGame packetIn) {
        this.parent.handleJoinGame(packetIn);
    }
    
    public void handleSpawnObject(final S0EPacketSpawnObject packetIn) {
        this.parent.handleSpawnObject(packetIn);
    }
    
    public void handleSpawnExperienceOrb(final S11PacketSpawnExperienceOrb packetIn) {
        this.parent.handleSpawnExperienceOrb(packetIn);
    }
    
    public void handleSpawnGlobalEntity(final S2CPacketSpawnGlobalEntity packetIn) {
        this.parent.handleSpawnGlobalEntity(packetIn);
    }
    
    public void handleSpawnPainting(final S10PacketSpawnPainting packetIn) {
        this.parent.handleSpawnPainting(packetIn);
    }
    
    public void handleEntityVelocity(final S12PacketEntityVelocity packetIn) {
        this.parent.handleEntityVelocity(packetIn);
    }
    
    public void handleEntityMetadata(final S1CPacketEntityMetadata packetIn) {
        this.parent.handleEntityMetadata(packetIn);
    }
    
    public void handleSpawnPlayer(final S0CPacketSpawnPlayer packetIn) {
        this.parent.handleSpawnPlayer(packetIn);
    }
    
    public void handleEntityTeleport(final S18PacketEntityTeleport packetIn) {
        this.parent.handleEntityTeleport(packetIn);
    }
    
    public void handleHeldItemChange(final S09PacketHeldItemChange packetIn) {
        this.parent.handleHeldItemChange(packetIn);
    }
    
    public void handleEntityMovement(final S14PacketEntity packetIn) {
        this.parent.handleEntityMovement(packetIn);
    }
    
    public void handleEntityHeadLook(final S19PacketEntityHeadLook packetIn) {
        this.parent.handleEntityHeadLook(packetIn);
    }
    
    public void handleDestroyEntities(final S13PacketDestroyEntities packetIn) {
        this.parent.handleDestroyEntities(packetIn);
    }
    
    public void handlePlayerPosLook(final S08PacketPlayerPosLook packetIn) {
        this.parent.handlePlayerPosLook(packetIn);
    }
    
    public void handleMultiBlockChange(final S22PacketMultiBlockChange packetIn) {
        this.parent.handleMultiBlockChange(packetIn);
    }
    
    public void handleChunkData(final S21PacketChunkData packetIn) {
        this.parent.handleChunkData(packetIn);
    }
    
    public void handleBlockChange(final S23PacketBlockChange packetIn) {
        this.parent.handleBlockChange(packetIn);
    }
    
    public void handleDisconnect(final S40PacketDisconnect packetIn) {
        this.parent.handleDisconnect(packetIn);
    }
    
    public void addToSendQueue(final Packet p_147297_1_) {
        this.parent.addToSendQueue(p_147297_1_);
    }
    
    public void onDisconnect(final IChatComponent reason) {
        this.parent.onDisconnect(reason);
    }
    
    public void handleCollectItem(final S0DPacketCollectItem packetIn) {
        this.parent.handleCollectItem(packetIn);
    }
    
    public void handleChat(final S02PacketChat packetIn) {
        this.parent.handleChat(packetIn);
    }
    
    public void handleAnimation(final S0BPacketAnimation packetIn) {
        this.parent.handleAnimation(packetIn);
    }
    
    public void handleUseBed(final S0APacketUseBed packetIn) {
        this.parent.handleUseBed(packetIn);
    }
    
    public void handleSpawnMob(final S0FPacketSpawnMob packetIn) {
        this.parent.handleSpawnMob(packetIn);
    }
    
    public void handleTimeUpdate(final S03PacketTimeUpdate packet) {
        switch (TimeChanger.TIME_TYPE) {
            case DAY: {
                this.parent.handleTimeUpdate(new S03PacketTimeUpdate(packet.getWorldTime(), -6000L, true));
            }
            case SUNSET: {
                this.parent.handleTimeUpdate(new S03PacketTimeUpdate(packet.getWorldTime(), -22880L, true));
            }
            case NIGHT: {
                this.parent.handleTimeUpdate(new S03PacketTimeUpdate(packet.getWorldTime(), -18000L, true));
            }
            case VANILLA: {
                this.parent.handleTimeUpdate(packet);
                break;
            }
        }
    }
    
    public void handleSpawnPosition(final S05PacketSpawnPosition packetIn) {
        this.parent.handleSpawnPosition(packetIn);
    }
    
    public void handleEntityAttach(final S1BPacketEntityAttach packetIn) {
        this.parent.handleEntityAttach(packetIn);
    }
    
    public void handleEntityStatus(final S19PacketEntityStatus packetIn) {
        this.parent.handleEntityStatus(packetIn);
    }
    
    public void handleUpdateHealth(final S06PacketUpdateHealth packetIn) {
        this.parent.handleUpdateHealth(packetIn);
    }
    
    public void handleSetExperience(final S1FPacketSetExperience packetIn) {
        this.parent.handleSetExperience(packetIn);
    }
    
    public void handleRespawn(final S07PacketRespawn packetIn) {
        this.parent.handleRespawn(packetIn);
    }
    
    public void handleExplosion(final S27PacketExplosion packetIn) {
        this.parent.handleExplosion(packetIn);
    }
    
    public void handleOpenWindow(final S2DPacketOpenWindow packetIn) {
        this.parent.handleOpenWindow(packetIn);
    }
    
    public void handleSetSlot(final S2FPacketSetSlot packetIn) {
        this.parent.handleSetSlot(packetIn);
    }
    
    public void handleConfirmTransaction(final S32PacketConfirmTransaction packetIn) {
        this.parent.handleConfirmTransaction(packetIn);
    }
    
    public void handleWindowItems(final S30PacketWindowItems packetIn) {
        this.parent.handleWindowItems(packetIn);
    }
    
    public void handleSignEditorOpen(final S36PacketSignEditorOpen packetIn) {
        this.parent.handleSignEditorOpen(packetIn);
    }
    
    public void handleUpdateSign(final S33PacketUpdateSign packetIn) {
        this.parent.handleUpdateSign(packetIn);
    }
    
    public void handleUpdateTileEntity(final S35PacketUpdateTileEntity packetIn) {
        this.parent.handleUpdateTileEntity(packetIn);
    }
    
    public void handleWindowProperty(final S31PacketWindowProperty packetIn) {
        this.parent.handleWindowProperty(packetIn);
    }
    
    public void handleEntityEquipment(final S04PacketEntityEquipment packetIn) {
        this.parent.handleEntityEquipment(packetIn);
    }
    
    public void handleCloseWindow(final S2EPacketCloseWindow packetIn) {
        this.parent.handleCloseWindow(packetIn);
    }
    
    public void handleBlockAction(final S24PacketBlockAction packetIn) {
        this.parent.handleBlockAction(packetIn);
    }
    
    public void handleBlockBreakAnim(final S25PacketBlockBreakAnim packetIn) {
        this.parent.handleBlockBreakAnim(packetIn);
    }
    
    public void handleMapChunkBulk(final S26PacketMapChunkBulk packetIn) {
        this.parent.handleMapChunkBulk(packetIn);
    }
    
    public void handleChangeGameState(final S2BPacketChangeGameState packet) {
        this.parent.handleChangeGameState(packet);
    }
    
    public void handleMaps(final S34PacketMaps packetIn) {
        this.parent.handleMaps(packetIn);
    }
    
    public void handleEffect(final S28PacketEffect packetIn) {
        this.parent.handleEffect(packetIn);
    }
    
    public void handleCombatEvent(final S42PacketCombatEvent packetIn) {
        this.parent.handleCombatEvent(packetIn);
    }
    
    public void handleServerDifficulty(final S41PacketServerDifficulty packetIn) {
        this.parent.handleServerDifficulty(packetIn);
    }
    
    public void handleCamera(final S43PacketCamera packetIn) {
        this.parent.handleCamera(packetIn);
    }
    
    public void handleWorldBorder(final S44PacketWorldBorder packetIn) {
        this.parent.handleWorldBorder(packetIn);
    }
    
    public void handleTitle(final S45PacketTitle packetIn) {
        this.parent.handleTitle(packetIn);
    }
    
    public void handleStatistics(final S37PacketStatistics packetIn) {
        this.parent.handleStatistics(packetIn);
    }
    
    public void handleSetCompressionLevel(final S46PacketSetCompressionLevel packetIn) {
        this.parent.handleSetCompressionLevel(packetIn);
    }
    
    public void handlePlayerListHeaderFooter(final S47PacketPlayerListHeaderFooter packetIn) {
        this.parent.handlePlayerListHeaderFooter(packetIn);
    }
    
    public void handleEntityEffect(final S1DPacketEntityEffect packetIn) {
        this.parent.handleEntityEffect(packetIn);
    }
    
    public void handleRemoveEntityEffect(final S1EPacketRemoveEntityEffect packetIn) {
        this.parent.handleRemoveEntityEffect(packetIn);
    }
    
    public void handlePlayerListItem(final S38PacketPlayerListItem packetIn) {
        this.parent.handlePlayerListItem(packetIn);
    }
    
    public void handleKeepAlive(final S00PacketKeepAlive packetIn) {
        this.parent.handleKeepAlive(packetIn);
    }
    
    public void handlePlayerAbilities(final S39PacketPlayerAbilities packetIn) {
        this.parent.handlePlayerAbilities(packetIn);
    }
    
    public void handleTabComplete(final S3APacketTabComplete packetIn) {
        this.parent.handleTabComplete(packetIn);
    }
    
    public void handleSoundEffect(final S29PacketSoundEffect packetIn) {
        this.parent.handleSoundEffect(packetIn);
    }
    
    public void handleResourcePack(final S48PacketResourcePackSend packetIn) {
        this.parent.handleResourcePack(packetIn);
    }
    
    public void handleEntityNBT(final S49PacketUpdateEntityNBT packetIn) {
        this.parent.handleEntityNBT(packetIn);
    }
    
    public void handleCustomPayload(final S3FPacketCustomPayload packetIn) {
        this.parent.handleCustomPayload(packetIn);
    }
    
    public void handleScoreboardObjective(final S3BPacketScoreboardObjective packetIn) {
        this.parent.handleScoreboardObjective(packetIn);
    }
    
    public void handleUpdateScore(final S3CPacketUpdateScore packetIn) {
        this.parent.handleUpdateScore(packetIn);
    }
    
    public void handleDisplayScoreboard(final S3DPacketDisplayScoreboard packetIn) {
        this.parent.handleDisplayScoreboard(packetIn);
    }
    
    public void handleTeams(final S3EPacketTeams packetIn) {
        this.parent.handleTeams(packetIn);
    }
    
    public void handleParticles(final S2APacketParticles packetIn) {
        this.parent.handleParticles(packetIn);
    }
    
    public void handleEntityProperties(final S20PacketEntityProperties packetIn) {
        this.parent.handleEntityProperties(packetIn);
    }
}

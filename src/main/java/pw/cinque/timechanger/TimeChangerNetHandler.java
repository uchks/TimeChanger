package pw.cinque.timechanger;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.*;
import net.minecraft.util.text.ITextComponent;

import java.lang.reflect.Field;

public class TimeChangerNetHandler extends NetHandlerPlayClient {
    private final NetHandlerPlayClient parent;

    public TimeChangerNetHandler(final NetHandlerPlayClient parent) {
        super(Minecraft.getMinecraft(), getGuiScreen(parent), parent.getNetworkManager(), parent.getGameProfile());
        this.parent = parent;
    }

    private static GuiScreen getGuiScreen(final NetHandlerPlayClient parent) {
        for (final Field field : parent.getClass().getDeclaredFields()) {
            if (field.getType().equals(GuiScreen.class)) {
                field.setAccessible(true);
                try {
                    return (GuiScreen) field.get(parent);
                } catch (Exception e) {
                    return null;
                }
            }
        }
        return null;
    }

    public void handleJoinGame(final SPacketJoinGame p_147282_1_) {
        this.parent.handleJoinGame(p_147282_1_);
    }

    public void handleSpawnObject(final SPacketSpawnObject p_147235_1_) {
        this.parent.handleSpawnObject(p_147235_1_);
    }

    public void handleSpawnExperienceOrb(final SPacketSpawnExperienceOrb p_147286_1_) {
        this.parent.handleSpawnExperienceOrb(p_147286_1_);
    }

    public void handleSpawnGlobalEntity(final SPacketSpawnGlobalEntity p_147292_1_) {
        this.parent.handleSpawnGlobalEntity(p_147292_1_);
    }

    public void handleSpawnPainting(final SPacketSpawnPainting p_147288_1_) {
        this.parent.handleSpawnPainting(p_147288_1_);
    }

    public void handleEntityVelocity(final SPacketEntityVelocity p_147244_1_) {
        this.parent.handleEntityVelocity(p_147244_1_);
    }

    public void handleEntityMetadata(final SPacketEntityMetadata p_147284_1_) {
        this.parent.handleEntityMetadata(p_147284_1_);
    }

    public void handleSpawnPlayer(final SPacketSpawnPlayer p_147237_1_) {
        this.parent.handleSpawnPlayer(p_147237_1_);
    }

    public void handleEntityTeleport(final SPacketEntityTeleport p_147275_1_) {
        this.parent.handleEntityTeleport(p_147275_1_);
    }

    public void handleHeldItemChange(final SPacketHeldItemChange p_147257_1_) {
        this.parent.handleHeldItemChange(p_147257_1_);
    }

    public void handleEntityMovement(final SPacketEntity p_147259_1_) {
        this.parent.handleEntityMovement(p_147259_1_);
    }

    public void handleEntityHeadLook(final SPacketEntityHeadLook p_147267_1_) {
        this.parent.handleEntityHeadLook(p_147267_1_);
    }

    public void handleDestroyEntities(final SPacketDestroyEntities p_147238_1_) {
        this.parent.handleDestroyEntities(p_147238_1_);
    }

    public void handlePlayerPosLook(final SPacketPlayerPosLook p_147258_1_) {
        this.parent.handlePlayerPosLook(p_147258_1_);
    }

    public void handleMultiBlockChange(final SPacketMultiBlockChange p_147287_1_) {
        this.parent.handleMultiBlockChange(p_147287_1_);
    }

    public void handleChunkData(final SPacketChunkData p_147263_1_) {
        this.parent.handleChunkData(p_147263_1_);
    }

    public void handleBlockChange(final SPacketBlockChange p_147234_1_) {
        this.parent.handleBlockChange(p_147234_1_);
    }

    public void handleDisconnect(final SPacketDisconnect p_147253_1_) {
        this.parent.handleDisconnect(p_147253_1_);
    }

    public void sendPacket(final Packet p_147297_1_) {
        this.parent.sendPacket(p_147297_1_);
    }

    public void onDisconnect(final ITextComponent p_147231_1_) {
        this.parent.onDisconnect(p_147231_1_);
    }

    public void handleCollectItem(final SPacketCollectItem p_147246_1_) {
        this.parent.handleCollectItem(p_147246_1_);
    }

    public void handleChat(final SPacketChat p_147251_1_) {
        this.parent.handleChat(p_147251_1_);
    }

    public void handleAnimation(final SPacketAnimation p_147279_1_) {
        this.parent.handleAnimation(p_147279_1_);
    }

    public void handleUseBed(final SPacketUseBed p_147278_1_) {
        this.parent.handleUseBed(p_147278_1_);
    }

    public void handleSpawnMob(final SPacketSpawnMob p_147281_1_) {
        this.parent.handleSpawnMob(p_147281_1_);
    }

    public void handleTimeUpdate(final SPacketTimeUpdate packet) {
        switch (TimeChanger.TIME_TYPE) {
            case DAY: {
                this.parent.handleTimeUpdate(new SPacketTimeUpdate(packet.getWorldTime(), -6000L, true));
            }
            case SUNSET: {
                this.parent.handleTimeUpdate(new SPacketTimeUpdate(packet.getWorldTime(), -22880L, true));
            }
            case NIGHT: {
                this.parent.handleTimeUpdate(new SPacketTimeUpdate(packet.getWorldTime(), -18000L, true));
            }
            case VANILLA: {
                this.parent.handleTimeUpdate(packet);
                break;
            }
            default:
                break;
        }
    }

    public void handleSpawnPosition(final SPacketSpawnPosition p_147271_1_) {
        this.parent.handleSpawnPosition(p_147271_1_);
    }

    public void handleEntityAttach(final SPacketEntityAttach p_147243_1_) {
        this.parent.handleEntityAttach(p_147243_1_);
    }

    public void handleEntityStatus(final SPacketEntityStatus p_147236_1_) {
        this.parent.handleEntityStatus(p_147236_1_);
    }

    public void handleUpdateHealth(final SPacketUpdateHealth p_147249_1_) {
        this.parent.handleUpdateHealth(p_147249_1_);
    }

    public void handleSetExperience(final SPacketSetExperience p_147295_1_) {
        this.parent.handleSetExperience(p_147295_1_);
    }

    public void handleRespawn(final SPacketRespawn p_147280_1_) {
        this.parent.handleRespawn(p_147280_1_);
    }

    public void handleExplosion(final SPacketExplosion p_147283_1_) {
        this.parent.handleExplosion(p_147283_1_);
    }

    public void handleOpenWindow(final SPacketOpenWindow p_147265_1_) {
        this.parent.handleOpenWindow(p_147265_1_);
    }

    public void handleSetSlot(final SPacketSetSlot p_147266_1_) {
        this.parent.handleSetSlot(p_147266_1_);
    }

    public void handleConfirmTransaction(final SPacketConfirmTransaction p_147239_1_) {
        this.parent.handleConfirmTransaction(p_147239_1_);
    }

    public void handleWindowItems(final SPacketWindowItems p_147241_1_) {
        this.parent.handleWindowItems(p_147241_1_);
    }

    public void handleSignEditorOpen(final SPacketSignEditorOpen p_147268_1_) {
        this.parent.handleSignEditorOpen(p_147268_1_);
    }

    public void handleUpdateTileEntity(final SPacketUpdateTileEntity p_147273_1_) {
        this.parent.handleUpdateTileEntity(p_147273_1_);
    }

    public void handleWindowProperty(final SPacketWindowProperty p_147245_1_) {
        this.parent.handleWindowProperty(p_147245_1_);
    }

    public void handleEntityEquipment(final SPacketEntityEquipment p_147242_1_) {
        this.parent.handleEntityEquipment(p_147242_1_);
    }

    public void handleCloseWindow(final SPacketCloseWindow p_147276_1_) {
        this.parent.handleCloseWindow(p_147276_1_);
    }

    public void handleBlockAction(final SPacketBlockAction p_147261_1_) {
        this.parent.handleBlockAction(p_147261_1_);
    }

    public void handleBlockBreakAnim(final SPacketBlockBreakAnim p_147294_1_) {
        this.parent.handleBlockBreakAnim(p_147294_1_);
    }

    public void handleChangeGameState(final SPacketChangeGameState packet) {
        this.parent.handleChangeGameState(packet);
    }

    public void handleMaps(final SPacketMaps p_147264_1_) {
        this.parent.handleMaps(p_147264_1_);
    }

    public void handleEffect(final SPacketEffect p_147277_1_) {
        this.parent.handleEffect(p_147277_1_);
    }

    public void handleCombatEvent(final SPacketCombatEvent packetIn) {
        this.parent.handleCombatEvent(packetIn);
    }

    public void handleServerDifficulty(final SPacketServerDifficulty packetIn) {
        this.parent.handleServerDifficulty(packetIn);
    }

    public void handleCamera(final SPacketCamera packetIn) {
        this.parent.handleCamera(packetIn);
    }

    public void handleWorldBorder(final SPacketWorldBorder packetIn) {
        this.parent.handleWorldBorder(packetIn);
    }

    public void handleTitle(final SPacketTitle packetIn) {
        this.parent.handleTitle(packetIn);
    }

    public void handleStatistics(final SPacketStatistics p_147293_1_) {
        this.parent.handleStatistics(p_147293_1_);
    }

    // public void handleSetCompressionLevel(final SPacketSetCompressionLevel packetIn) {
    // this.parent.handleSetCompressionLevel(packetIn);
    // }

    public void handlePlayerListHeaderFooter(final SPacketPlayerListHeaderFooter packetIn) {
        this.parent.handlePlayerListHeaderFooter(packetIn);
    }

    public void handleEntityEffect(final SPacketEntityEffect p_147260_1_) {
        this.parent.handleEntityEffect(p_147260_1_);
    }

    public void handleRemoveEntityEffect(final SPacketRemoveEntityEffect p_147262_1_) {
        this.parent.handleRemoveEntityEffect(p_147262_1_);
    }

    public void handlePlayerListItem(final SPacketPlayerListItem p_147256_1_) {
        this.parent.handlePlayerListItem(p_147256_1_);
    }

    public void handleKeepAlive(final SPacketKeepAlive p_147272_1_) {
        this.parent.handleKeepAlive(p_147272_1_);
    }

    public void handlePlayerAbilities(final SPacketPlayerAbilities p_147270_1_) {
        this.parent.handlePlayerAbilities(p_147270_1_);
    }

    public void handleTabComplete(final SPacketTabComplete p_147274_1_) {
        this.parent.handleTabComplete(p_147274_1_);
    }

    public void handleSoundEffect(final SPacketSoundEffect p_147255_1_) {
        this.parent.handleSoundEffect(p_147255_1_);
    }

    public void handleResourcePack(final SPacketResourcePackSend packetIn) {
        this.parent.handleResourcePack(packetIn);
    }

    public void handleUpdateBossInfo(final SPacketUpdateBossInfo packetIn) {
        this.parent.handleUpdateBossInfo(packetIn);
    }

    public void handleCustomPayload(final SPacketCustomPayload p_147240_1_) {
        this.parent.handleCustomPayload(p_147240_1_);
    }

    public void handleScoreboardObjective(final SPacketScoreboardObjective p_147291_1_) {
        this.parent.handleScoreboardObjective(p_147291_1_);
    }

    public void handleUpdateScore(final SPacketUpdateScore p_147250_1_) {
        this.parent.handleUpdateScore(p_147250_1_);
    }

    public void handleDisplayObjective(final SPacketDisplayObjective p_147254_1_) {
        this.parent.handleDisplayObjective(p_147254_1_);
    }

    public void handleTeams(final SPacketTeams p_147247_1_) {
        this.parent.handleTeams(p_147247_1_);
    }

    public void handleParticles(final SPacketParticles p_147289_1_) {
        this.parent.handleParticles(p_147289_1_);
    }

    public void handleEntityProperties(final SPacketEntityProperties p_147290_1_) {
        this.parent.handleEntityProperties(p_147290_1_);
    }
}

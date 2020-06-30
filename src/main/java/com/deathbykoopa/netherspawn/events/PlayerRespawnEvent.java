package com.deathbykoopa.netherspawn.events;

import com.deathbykoopa.netherspawn.NetherSpawn;
import com.deathbykoopa.netherspawn.SpawnHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "netherspawn", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerRespawnEvent
{
    @SubscribeEvent
    public static void playerRespawnEvent(PlayerEvent.PlayerRespawnEvent event)
    {
        PlayerEntity player = event.getPlayer();
        ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;

        // This method returns a the player's respawn position
        BlockPos respawnPos = serverPlayer.func_241140_K_();

        // If null, no bed or respawn anchor is assigned
        if(respawnPos == null)
        {
            SpawnHelper.respawnInNether(player);
        }
    }
}
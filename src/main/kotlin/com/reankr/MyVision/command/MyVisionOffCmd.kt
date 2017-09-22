package com.reankr.MyVision.command

import com.korotyx.Rebukkit.command.RebukkitCommand
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffectType

class MyVisionOffCmd : RebukkitCommand<MyVisionOffCmd>("off")
{
    init
    {
        this.setPermission("settime")
        this.setDescription("야간 투시를 끕니다.")
    }

    override fun onCommand(sender: CommandSender, args: List<String>): Boolean
    {
        val player : Player = sender as Player
        player.removePotionEffect(PotionEffectType.NIGHT_VISION)
        player.removePotionEffect(PotionEffectType.WATER_BREATHING)
        this.send(player, "&b야간 투시가 꺼졌습니다.")
        return true
    }
}
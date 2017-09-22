package com.reankr.MyVision.command

import com.korotyx.Rebukkit.command.RebukkitCommand
import com.korotyx.Rebukkit.command.misc.Parameter
import com.korotyx.Rebukkit.command.misc.ParameterType

import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class MyVisionOnCmd : RebukkitCommand<MyVisionOnCmd>("on")
{
    companion object
    public val DEFAULT_TIME : Int = 420000000

    init
    {
        this.setPermission("settime")
        this.addDescription("야간 투시를 [숫자]초만큼 켭니다.")
        this.addDescription("숫자에 아무것도 입력하지 않으면 계속 켜져 있습니다.")
        this.addParameter(Parameter("숫자", ParameterType.OPTIONAL))
    }

    override fun onCommand(sender: CommandSender, args: List<String>): Boolean
    {
        val player : Player = sender as Player
        if(player.hasPotionEffect(PotionEffectType.NIGHT_VISION))
        {
            this.send(player, "야간 투시가 이미 활성화 된 상태입니다.")
            return false
        }

        player.removePotionEffect(PotionEffectType.NIGHT_VISION)
        player.removePotionEffect(PotionEffectType.WATER_BREATHING)

        if(args.isNotEmpty())
        {
            var millsTime : Int = try {
                Integer.valueOf(args[0])
            } catch(e: NumberFormatException){
                DEFAULT_TIME
            }
            player.addPotionEffect(PotionEffect(PotionEffectType.NIGHT_VISION, millsTime, 1))
            player.addPotionEffect(PotionEffect(PotionEffectType.NIGHT_VISION, millsTime, 1))
            this.send(sender, "&a야간 투시가 {0}초만큼 활성화됨", millsTime)
        }
        else
        {
            player.addPotionEffect(PotionEffect(PotionEffectType.NIGHT_VISION, DEFAULT_TIME, 1))
            player.addPotionEffect(PotionEffect(PotionEffectType.NIGHT_VISION, DEFAULT_TIME, 1))
            this.send(sender, " &a야간 투시가 지속적으로 활성화됨")

        }
        return true
    }
}
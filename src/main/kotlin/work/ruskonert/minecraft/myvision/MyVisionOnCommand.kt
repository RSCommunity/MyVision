package work.ruskonert.minecraft.myvision

import io.github.ruskonert.ruskit.command.RuskitCommand
import io.github.ruskonert.ruskit.command.misc.Parameter
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class MyVisionOnCommand : RuskitCommand<MyVisionOnCommand>("on")
{
    init
    {
        this.setPermission("on")
        this.addParameter(Parameter("time", false))
        this.setCommandDescription("Turn on the night vision of player")
    }



    companion object val DEFAULT_TIME = Int.MAX_VALUE;

    override fun perform(sender: CommandSender, argc: Int, argv: List<String>?, handleInstance: Any?): Any?
    {
        val messageHandler = this.getPlugin()!!.getMessageHandler()
        if(sender is ConsoleCommandSender)
        {
            return false
        }

        val player : Player = sender as Player
        if(player.hasPotionEffect(PotionEffectType.NIGHT_VISION))
        {
            messageHandler.defaultMessage("The night vision was already activated", player)
            return false
        }

        player.removePotionEffect(PotionEffectType.NIGHT_VISION)
        player.removePotionEffect(PotionEffectType.WATER_BREATHING)

        if(argv!!.isNotEmpty())
        {
            var millsTime : Int = try
            {
                Integer.valueOf(argv!![0])
            }
            catch(e: NumberFormatException)
            {
                DEFAULT_TIME
            }
            player.addPotionEffect(PotionEffect(PotionEffectType.NIGHT_VISION, millsTime, 1))
            player.addPotionEffect(PotionEffect(PotionEffectType.NIGHT_VISION, millsTime, 1))
            messageHandler.defaultMessage("&aThe night vision now activated for ${millsTime} second(s)", player)
        }
        else
        {
            player.addPotionEffect(PotionEffect(PotionEffectType.NIGHT_VISION, DEFAULT_TIME, 1))
            player.addPotionEffect(PotionEffect(PotionEffectType.NIGHT_VISION, DEFAULT_TIME, 1))
            messageHandler.defaultMessage(" &aThe night vision now activated for infinity", player)

        }
        return true
    }
}

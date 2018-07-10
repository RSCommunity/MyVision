package work.ruskonert.minecraft.myvision

import io.github.ruskonert.ruskit.command.RuskitCommand
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffectType

class MyVisionOffCommand : RuskitCommand<MyVisionOffCommand>("off")
{
    init
    {
        this.setPermission("on")
        this.setCommandDescription("Turn on the night vision of player")
    }

    override fun perform(sender: CommandSender, argc: Int, argv: List<String>?, handleInstance: Any?): Any?
    {
        val messageHandler = this.getPlugin()!!.getMessageHandler()
        if(sender is ConsoleCommandSender)
            return false
        val player : Player = sender as Player
        player.removePotionEffect(PotionEffectType.NIGHT_VISION)
        player.removePotionEffect(PotionEffectType.WATER_BREATHING)
        messageHandler.defaultMessage("&bTurn off the night vision", player)
        return true
    }
}
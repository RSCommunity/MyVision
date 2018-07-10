package work.ruskonert.minecraft.myvision

import io.github.ruskonert.ruskit.command.RuskitCommand

class MyVisionCommand : RuskitCommand<MyVisionCommand>("myvision", "mvision")
{
    private val cmd = MyVisionOnCommand()
    private val cmd2 = MyVisionOffCommand()

    init
    {
        this.addChildCommands(cmd, cmd2)
        this.setPermission("myvision")
    }
}
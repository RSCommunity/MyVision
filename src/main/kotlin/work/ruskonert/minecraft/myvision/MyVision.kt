package work.ruskonert.minecraft.myvision

import io.github.ruskonert.ruskit.plugin.IntegratedPlugin

class MyVision : IntegratedPlugin()
{
    override fun onInit(handleInstance: Any?): Any?
    {
        super.onInit(this)
        this.registerSustainableHandlers(MyVisionCommand::class.java)
        return true
    }
}

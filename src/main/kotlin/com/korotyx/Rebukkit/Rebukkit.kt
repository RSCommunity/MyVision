package com.korotyx.Rebukkit

import org.bukkit.plugin.java.JavaPlugin

open class Rebukkit : JavaPlugin()
{
    protected open fun onEnableInner(handleInstance : Any?) : Boolean
    {
        return true
    }

    protected open fun onDisableInner() : Boolean
    {
        return true
    }

    override final fun onEnable()
    {
        onEnableInner()
    }


    override final fun onDisable()
    {
        onDisableInner()
    }

    open fun preLoad()
    {

    }

    open fun preUnload()
    {

    }


}
package com.reankr.MyVision

import com.korotyx.Rebukkit.Rebukkit

class MyVision : Rebukkit()
{
    override fun onEnableInner(handleInstance: Any?): Boolean
    {
        return super.onEnableInner(this)
    }

    override fun onDisableInner() : Boolean
    {
        return true
    }
}
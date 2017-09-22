package com.reankr.MyVision.command

import com.korotyx.Rebukkit.command.RebukkitCommand

class MyVisionCmd : RebukkitCommand<MyVisionCmd>("mvision")
{
    private val myVisionOn  : MyVisionOnCmd    = MyVisionOnCmd()

    private val myVisionOff : MyVisionOffCmd   = MyVisionOffCmd()

    init
    {
        this.addAliasCommand("vision", "mv")
        this.setPermissionSkeleton("myvision")
        this.setDescription("MyVision 도움말 보기")
        this.addChild(
                myVisionOn,
                myVisionOff
        )
    }
}
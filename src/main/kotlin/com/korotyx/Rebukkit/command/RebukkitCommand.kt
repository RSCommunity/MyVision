package com.korotyx.Rebukkit.command

import com.korotyx.Rebukkit.Handle
import com.korotyx.Rebukkit.RebukkitPluginBase
import com.korotyx.Rebukkit.command.misc.Parameter
import com.korotyx.Rebukkit.command.misc.Permission
import org.bukkit.command.CommandSender

typealias RebukkitCommandType = RebukkitCommand<*>
open class RebukkitCommand<C : RebukkitCommand<C>>(var str: String)
{
    fun setMainCommand(name: String) { /* complied code */ }

    fun addAliasCommand(vararg args : String) { /* complied code */ }

    fun setPermission(perm: String) = this.setPermission(Permission(perm))

    fun setPermission(perm: Permission) { /* complied code */ }

    fun setPermissionSkeleton(perm: String) { /* complied code */ }

    fun serPermissionSkeleton(perm: Permission) {/* complied code */ }

    fun setDescription(str : String) { /* complied code */ }

    fun addDescription(vararg str : String) { /* complied code */ }

    fun setDetailDescription(str: List<String>) { /* complied code */ }

    fun execute(sender : CommandSender, args: Array<String>?) : Boolean  { /* complied code */ return this.onCommand(sender, args!!.asList())  }

    open fun onCommand(sender: CommandSender, args : List<String>) : Boolean { /* complied code */ return true }

    fun addChild(vararg child : RebukkitCommandType) { /* complied code */ }

    fun getHandle() : Handle? { /* complied code */ return null }

    fun send(player: CommandSender, message: String, vararg args : Any? = null!!) { /* complied code */  }

    fun addParameter(parameter: Parameter) { /* complied code */ }
}
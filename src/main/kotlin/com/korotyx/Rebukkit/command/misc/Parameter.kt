package com.korotyx.Rebukkit.command.misc

class Parameter(name: String, type: ParameterType) {

}

enum class ParameterType
{
    REQUIREMENT {
        override fun switch(): ParameterType = OPTIONAL
    },

    OPTIONAL
    {
        override fun switch(): ParameterType = REQUIREMENT
    };

    abstract fun switch() : ParameterType
}

package com.rnett.kframejs.bootstrap

enum class ViewportBreakpoint(val css: String) {

    None(""), Small("sm"), Medium("md"), Large("lg"), ExtraLarge("xl");

    override fun toString() = css
}
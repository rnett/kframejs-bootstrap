package com.rnett.kframejs.bootstrap.layout

import com.rnett.kframejs.bootstrap.ViewportBreakpoint
import com.rnett.kframejs.structure.addons.HasClass
import com.rnett.kframejs.structure.element.DisplayElement
import com.rnett.kframejs.structure.element.ElementBuilder
import com.rnett.kframejs.structure.element.KFrameElementDSL
import org.w3c.dom.HTMLDivElement
import kotlin.properties.Delegates

enum class ColumnVerticalAlignment(override val klass: String) : HasClass {
    Top("align-self-start"), Center("align-self-center"), Bottom("align-self-end");

    override fun toString() = klass
}

class Col(parent: Row) : DisplayElement<Col, HTMLDivElement>("div", parent) {

    val selfVerticalAlignment by classes.by<ColumnVerticalAlignment>()

    private var colClass
        get() = classes.find { it.startsWith("col") }!!
        set(value) {
            classes.removeAll { it.startsWith("col") }
            classes.add(value)
        }

    private fun getColClass() = buildString {
        append("col")

        if (breakpoint != null && breakpoint != ViewportBreakpoint.None)
            append("-$breakpoint")

        if (size != null)
            append("-$size")
        else if (auto)
            append("-auto")
    }

    private fun refreshRowClass() {
        colClass = getColClass()
    }

    var size: Int? by Delegates.observable<Int?>(null) { _, _, new ->
        if (new != null)
            auto = false
        refreshRowClass()
    }

    var auto: Boolean by Delegates.observable(false) { _, _, new ->
        if (new)
            size = null
        refreshRowClass()
    }

    var breakpoint: ViewportBreakpoint? by Delegates.observable<ViewportBreakpoint?>(null) { _, _, new ->
        refreshRowClass()
    }
}

@KFrameElementDSL
inline fun Row.col(
    breakpoint: ViewportBreakpoint? = null,
    klass: String = "",
    id: String = "",
    crossinline builder: ElementBuilder<Col> = {}
) =
    Col(this).invoke {
        this.klass = "col $klass"
        if (id != "")
            this.id = id
        this.breakpoint = breakpoint
        builder()
    }


@KFrameElementDSL
inline fun Row.col(
    size: Int,
    breakpoint: ViewportBreakpoint? = null,
    klass: String = "",
    id: String = "",
    crossinline builder: ElementBuilder<Col> = {}
) =
    col(breakpoint, klass, id) {
        this.size = size
        builder()
    }


@KFrameElementDSL
inline fun Row.autoCol(
    breakpoint: ViewportBreakpoint? = null,
    klass: String = "",
    id: String = "",
    crossinline builder: ElementBuilder<Col> = {}
) =
    col(breakpoint, klass, id) {
        this.auto = true
        builder()
    }

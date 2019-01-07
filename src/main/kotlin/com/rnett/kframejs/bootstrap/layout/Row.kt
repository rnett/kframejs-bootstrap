package com.rnett.kframejs.bootstrap.layout

import com.rnett.kframejs.dom.div
import com.rnett.kframejs.structure.addons.HasClass
import com.rnett.kframejs.structure.element.*
import org.w3c.dom.HTMLDivElement


enum class RowVerticalAlignment(override val klass: String) : HasClass {

    Top("align-items-start"), Center("align-items-center"), Bottom("align-items-end");

    override fun toString() = klass
}

enum class RowHorizontalAlignment(override val klass: String) : HasClass {

    Start("justify-content-start"), Center("justify-content-center"), End("justify-content-end"),
    Around("justify-content-around"), Between("justify-content-between");

    override fun toString() = klass
}

class Row(parent: CanHaveElement<*>) : DisplayElement<Row, HTMLDivElement>("div", parent) {
    var verticalAlignment by classes.by<RowVerticalAlignment>()
    var horizontalAlignment by classes.by<RowHorizontalAlignment>()
}

@KFrameElementDSL
inline fun <ParentType> ParentType.row(
    klass: String = "",
    id: String = "",
    crossinline builder: ElementBuilder<Row> = {}
)
        where ParentType : AnyDisplayElement, ParentType : CanHaveElement<*> =
    Row(this).invoke {
        this.klass = "row $klass"
        if (id != "")
            this.id = id
        builder()
    }

@KFrameElementDSL
inline fun <ParentType> ParentType.row(
    alignVertical: RowVerticalAlignment,
    alignHorizontal: RowHorizontalAlignment,
    klass: String = "",
    id: String = "",
    crossinline builder: ElementBuilder<Row> = {}
)
        where ParentType : AnyDisplayElement, ParentType : CanHaveElement<*> =
    row(klass, id) {

        verticalAlignment = alignVertical
        horizontalAlignment = alignHorizontal

        builder()
    }

@KFrameElementDSL
inline fun Row.rowBreak(
    klass: String = "",
    id: String = "",
    crossinline builder: StandardDisplayElementBuilder<HTMLDivElement> = {}
) =
    div("w-100 $klass", id, builder)
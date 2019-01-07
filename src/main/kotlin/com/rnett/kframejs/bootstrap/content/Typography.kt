package com.rnett.kframejs.bootstrap.content

import com.rnett.kframejs.dom.h
import com.rnett.kframejs.structure.addons.addClass
import com.rnett.kframejs.structure.element.*
import org.w3c.dom.HTMLHeadingElement

fun AnyElement.textMuted() = addClass("text-muted")
fun AnyElement.leadText() = addClass("lead")

@KFrameElementDSL
inline fun <ParentType> ParentType.displayHeading(
    size: Int,
    klass: String = "",
    id: String = "",
    crossinline builder: StandardDisplayElementBuilder<HTMLHeadingElement> = {}
)
        where ParentType : AnyDisplayElement, ParentType : CanHaveElement<*> =
    h(1, "display-$size $klass", id, builder)


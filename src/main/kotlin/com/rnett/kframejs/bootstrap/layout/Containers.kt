package com.rnett.kframejs.bootstrap.layout

import com.rnett.kframejs.dom.div
import com.rnett.kframejs.structure.element.AnyDisplayElement
import com.rnett.kframejs.structure.element.CanHaveElement
import com.rnett.kframejs.structure.element.KFrameElementDSL
import com.rnett.kframejs.structure.element.StandardDisplayElementBuilder
import org.w3c.dom.HTMLDivElement

@KFrameElementDSL
inline fun <ParentType> ParentType.container(
    klass: String = "",
    id: String = "",
    crossinline builder: StandardDisplayElementBuilder<HTMLDivElement> = {}
)
        where ParentType : AnyDisplayElement, ParentType : CanHaveElement<*> =
    div("container $klass", id, builder)

@KFrameElementDSL
inline fun <ParentType> ParentType.containerFluid(
    klass: String = "",
    id: String = "",
    crossinline builder: StandardDisplayElementBuilder<HTMLDivElement> = {}
)
        where ParentType : AnyDisplayElement, ParentType : CanHaveElement<*> =
    div("container-fluid $klass", id, builder)

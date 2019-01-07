package com.rnett.kframejs.bootstrap.content

import com.rnett.kframejs.dom.classes.ImageElement
import com.rnett.kframejs.dom.img
import com.rnett.kframejs.structure.addons.addClass
import com.rnett.kframejs.structure.element.AnyDisplayElement
import com.rnett.kframejs.structure.element.CanHaveElement
import com.rnett.kframejs.structure.element.ElementBuilder
import com.rnett.kframejs.structure.element.KFrameElementDSL

fun ImageElement.responsive() = addClass("img-fluid")

@KFrameElementDSL
inline fun <ParentType> ParentType.responsiveImage(
    src: String,
    klass: String = "",
    id: String = "",
    crossinline builder: ElementBuilder<ImageElement> = {}
)
        where ParentType : AnyDisplayElement, ParentType : CanHaveElement<*> =
    img(src, klass, id) {
        responsive()
        builder()
    }

fun ImageElement.thumbnail() = addClass("img-thumbnail")


